package com.example.academy.data.source

import com.example.academy.data.source.remote.RemoteDataSource
import com.example.academy.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

class AcademyRepositoryTest {
    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val academyRepository = FakeAcademyRepository(remote)

    private val courseResponses = DataDummy.generateRemoteDummyCourses()
    private val courseId = courseResponses[0].id
    private val moduleResponse = DataDummy.generateRemoteDummyModules(courseId)
    private val moduleId = moduleResponse[0].moduleId
    private val content = DataDummy.generateRemoteDummyContent(moduleId)

    @Test
    fun getAllCourses() {
        `when`(remote.getAllCourses()).thenReturn(courseResponses)
        val courseEntites = academyRepository.getAllCourses()
        verify(remote).getAllCourses()
        assertNotNull(courseEntites)
        assertEquals(courseResponses.size.toLong(), courseEntites.size.toLong())
    }

    @Test
    fun getAllModulesByCourse() {
        `when`(remote.getModules(courseId)).thenReturn(moduleResponse)
        val moduleEntites = academyRepository.getAllModulesByCourse(courseId)
        verify(remote).getModules(courseId)
        assertNotNull(moduleEntites)
        assertEquals(moduleResponse.size.toLong(), moduleEntites.size.toLong())
    }

    @Test
    fun getBookmarkedCourses() {
        `when`(remote.getAllCourses()).thenReturn(courseResponses)
        val courseEntites = academyRepository.getBookmarkedCourses()
        verify(remote).getAllCourses()
        assertNotNull(courseEntites)
        assertEquals(courseResponses.size.toLong(), courseEntites.size.toLong())
    }

    @Test
    fun getContent() {
        `when`(remote.getModules(courseId)).thenReturn(moduleResponse)
        `when`(remote.getContent(moduleId)).thenReturn(content)
        val resultModule = academyRepository.getContent(courseId, moduleId)
        verify(remote).getContent(moduleId)
        assertNotNull(resultModule)
        assertEquals(content.content, resultModule.contentEntity?.content)
    }

    @Test
    fun getCourseWithModules() {
        `when`(remote.getAllCourses()).thenReturn(courseResponses)
        val resultCourse = academyRepository.getCourseWithModules(courseId)
        verify(remote).getAllCourses()
        assertNotNull(resultCourse)
        assertEquals(courseResponses[0].title, resultCourse.title)
    }

}