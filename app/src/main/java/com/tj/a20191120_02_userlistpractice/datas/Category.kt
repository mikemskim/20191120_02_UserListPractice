package com.tj.a20191120_02_userlistpractice.datas

import org.json.JSONObject

class Category {

    var id = 0
    var title = ""
    var color = ""

    companion object {
        fun getCategoryFromJson(categoryJson:JSONObject) : Category {
            var categoryObject = Category()

            categoryObject.id = categoryJson.getInt("id")
            categoryObject.title = categoryJson.getString("title")
            categoryObject.color = categoryJson.getString("color")

            return categoryObject
        }
    }
}