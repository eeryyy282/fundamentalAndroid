package com.example.fundamentalandroid.learntest

class MainViewModelTest(private val cuboidModel: CuboidModel) {

    fun getCircumference() = cuboidModel.getCircumference()

    fun getSurfaceArea() = cuboidModel.getSurfaveArea()

    fun getVolume() = cuboidModel.getVolume()

    fun save(w: Double, l: Double, h: Double) {
        cuboidModel.save(w, l, h)
    }
}