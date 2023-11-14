package com.roshanadke.checkit.data.repository

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.roshanadke.checkit.data.getToDoEntityList
import com.roshanadke.checkit.data.local.TodoListDaoFake
import com.roshanadke.checkit.data.local.entity.ToDoEntity
import kotlinx.coroutines.runBlocking

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test


internal class ToDoItemsRepositoryImplTest {

    private lateinit var dao: TodoListDaoFake
    private lateinit var toDoItemsRepositoryImpl: ToDoItemsRepositoryImpl

    @BeforeEach
    fun setUp() {
        dao = TodoListDaoFake()
        toDoItemsRepositoryImpl = ToDoItemsRepositoryImpl(dao)
    }

    @Test
    fun `Test save todo item`() = runBlocking  {
        dao = TodoListDaoFake()
        toDoItemsRepositoryImpl = ToDoItemsRepositoryImpl(dao)
        val entity = ToDoEntity(
            title = "Test title",
            isCompleted = false
        )
        assertThat(dao.entityList.size).isEqualTo(0)
        toDoItemsRepositoryImpl.addToDoItem(entity)
        ///assertEquals(dao.entityList.size, 1)a
        assertThat(dao.entityList.size).isEqualTo(1)
    }

    @Test
    fun `Test update todo item`() = runBlocking  {
        dao = TodoListDaoFake()
        toDoItemsRepositoryImpl = ToDoItemsRepositoryImpl(dao)
        val entityList = getToDoEntityList()

        entityList.forEach {
            toDoItemsRepositoryImpl.addToDoItem(it)
        }

        assertThat(dao.entityList.size).isEqualTo(3)

        val updatedEntity = entityList[0].copy(title = "Changed title")
        val updatedEntity2 = entityList[1].copy(title = "Changed title two")

        toDoItemsRepositoryImpl.updateToDoItem(updatedEntity)
        toDoItemsRepositoryImpl.updateToDoItem(updatedEntity2)

        assertThat(dao.entityList.size).isEqualTo(3)
        assertThat(dao.entityList[0].title).isEqualTo("Changed title")
        assertThat(dao.entityList[1].title).isEqualTo("Changed title two")

    }

    @Test
    fun `test another`()  {
        assertThat(0).isEqualTo(0)
    }




}