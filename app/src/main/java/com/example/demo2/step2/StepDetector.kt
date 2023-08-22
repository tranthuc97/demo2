package com.example.demo2.step2

import androidx.lifecycle.MutableLiveData

class StepDetector {
    private val ACCELERATOR_RING_SIZE = 50
    private val VEL_RING_SIZE = 10

    private val STEP_THRESHOLD = 50f

    private val STEP_DELAY_NS = 250000000

    private var acceleratorRingCounter = 0
    private val accelRingX = FloatArray(ACCELERATOR_RING_SIZE)
    private val accelRingY = FloatArray(ACCELERATOR_RING_SIZE)
    private val accelRingZ = FloatArray(ACCELERATOR_RING_SIZE)
    private var velRingCounter = 0
    private val velRing = FloatArray(VEL_RING_SIZE)
    private var lastStepTimeNs: Long = 0
    private var oldVelocityEstimate = 0f

    private var listener: StepListener? = null

    fun registerListener(listener: StepListener?) {
        this.listener = listener
    }


    fun updateAccel(timeNs: Long, x: Float, y: Float, z: Float) {
        val currentAccelerator = FloatArray(3)
        currentAccelerator[0] = x
        currentAccelerator[1] = y
        currentAccelerator[2] = z
        acceleratorRingCounter++
        accelRingX[acceleratorRingCounter % ACCELERATOR_RING_SIZE] = currentAccelerator[0]
        accelRingY[acceleratorRingCounter % ACCELERATOR_RING_SIZE] = currentAccelerator[1]
        accelRingZ[acceleratorRingCounter % ACCELERATOR_RING_SIZE] = currentAccelerator[2]
        val valueX = FloatArray(3)
        valueX[0] =
            SensorFilter().sum(accelRingX) / Math.min(acceleratorRingCounter, ACCELERATOR_RING_SIZE)
        valueX[1] =
            SensorFilter().sum(accelRingY) / Math.min(acceleratorRingCounter, ACCELERATOR_RING_SIZE)
        valueX[2] =
            SensorFilter().sum(accelRingZ) / Math.min(acceleratorRingCounter, ACCELERATOR_RING_SIZE)
        val normalization_factor = SensorFilter().norm(valueX)
        valueX[0] = valueX[0] / normalization_factor
        valueX[1] = valueX[1] / normalization_factor
        valueX[2] = valueX[2] / normalization_factor
        val currentX = SensorFilter().dot(valueX, currentAccelerator) - normalization_factor
        velRingCounter++
        velRing[velRingCounter % VEL_RING_SIZE] = currentX
        val velocityEstimate = SensorFilter().sum(velRing)
        if (velocityEstimate > STEP_THRESHOLD && oldVelocityEstimate!! <= STEP_THRESHOLD && timeNs - lastStepTimeNs > STEP_DELAY_NS) {
            listener!!.step(timeNs)
            lastStepTimeNs = timeNs
        }
        oldVelocityEstimate = velocityEstimate
    }
}