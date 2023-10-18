package me.modorigoon.pay.common

import org.springframework.context.annotation.Configuration
import java.util.concurrent.CountDownLatch


@Configuration
class CountDownLatchManager(
    val countDownLatchMap: MutableMap<String, CountDownLatch> = HashMap(),
    val stringMap: MutableMap<String, String> = HashMap()
) {
    fun addCountDownLatch(key: String) {
        this.countDownLatchMap[key] = CountDownLatch(1)
    }

    fun setDataForKey(key: String, data: String) {
        this.stringMap[key] = data
    }

    fun getDataForKey(key: String): String? = this.stringMap[key]

    fun getCountDownLatch(key: String): CountDownLatch {
        if (countDownLatchMap[key] == null) {
            addCountDownLatch(key)
        }
        return this.countDownLatchMap[key]!!
    }
}
