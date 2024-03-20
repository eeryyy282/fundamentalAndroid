package com.example.fundamentalandroid.learntest

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

class MainViewModelTestTest {

    private lateinit var mainViewModelTest: MainViewModelTest
    private lateinit var cuboidModel: CuboidModel

    private val dummyLength = 12.00
    private val dummyHeight = 6.0
    private val dummyWidth = 7.0

    private val dummyVolume = 504.0
    private val dummyCircumference = 100.0
    private val dummySurfaceArea = 396.0

    @Before
    fun before() {
        cuboidModel = mock(CuboidModel::class.java)
        mainViewModelTest = MainViewModelTest(cuboidModel)
        mainViewModelTest.save(dummyWidth, dummyLength, dummyHeight)
        val circumference = mainViewModelTest.getCircumference()
        assertEquals(dummyCircumference, circumference, 0.0001)
    }

    @Test
    fun getCircumference() {
        cuboidModel = CuboidModel()
        mainViewModelTest = MainViewModelTest(cuboidModel)
        mainViewModelTest.save(dummyWidth, dummyHeight, dummyLength)
        val circumference = mainViewModelTest.getCircumference()
        assertEquals(dummyCircumference, circumference, 0.0001)
    }

    @Test
    fun testSurfaceArea() {
        cuboidModel = CuboidModel()
        mainViewModelTest = MainViewModelTest(cuboidModel)
        mainViewModelTest.save(dummyWidth, dummyLength, dummyHeight)
        val surfaceArea = mainViewModelTest.getSurfaceArea()
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001)
    }

    @Test
    fun testMockVolume() {
        `when`(mainViewModelTest.getVolume()).thenReturn(dummyVolume)
        val volume = mainViewModelTest.getVolume()
        verify(cuboidModel).getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }

    @Test
    fun testMockCircumference() {
        `when`(mainViewModelTest.getCircumference()).thenReturn(dummyCircumference)
        val circumference = mainViewModelTest.getCircumference()
        verify(cuboidModel).getCircumference()
        assertEquals(dummyCircumference, circumference, 0.0001)
    }

    @Test
    fun testMockSurfaceArea() {
        `when`(mainViewModelTest.getSurfaceArea()).thenReturn(dummySurfaceArea)
        val surfaceArea = mainViewModelTest.getSurfaceArea()
        verify(cuboidModel).getSurfaveArea()
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001)
    }

//    @Test
//    fun testVolume() {
//        cuboidModel = CuboidModel()
//        mainViewModelTest = MainViewModelTest(cuboidModel)
//        mainViewModelTest.save(dummyWidth, dummyLength, dummyHeight)
//        val volume = mainViewModelTest.getVolume()
//        assertEquals(dummyVolume, volume, 0.0001)
//    }
}