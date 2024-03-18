package com.comunidadedevspace.taskbeats

import kotlin.random.Random

interface MyCountRepository {
    fun sum(): Int

    fun sub(num1: Int, num2: Int): Int

}

class MyCountRepositoryImpl(
    private val numbersProvider: MyNumbersProvider
)
    : MyCountRepository {
    override fun sum(): Int {
        val num1 = numbersProvider.getNumber()
        val num2 = numbersProvider.getNumber()
        return num1 + num2
    }


    override fun sub(num1: Int, num2: Int): Int {
        return num1 - num2
    }

}

interface MyNumbersProvider{

    fun getNumber():Int
}

class MyNumbersProviderImpl(): MyNumbersProvider{
    override fun getNumber(): Int {
        return Random.nextInt(from = 0, until = 100)
    }

}
