package com.tj.a20191120_02_userlistpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tj.a20191120_02_userlistpractice.datas.User
import com.tj.a20191120_02_userlistpractice.utils.ConnectServer
import org.json.JSONObject

class UserDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)



        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
        var userData = intent.getSerializableExtra("user") as User



    }

    fun getCategoryListFromServer(){
        ConnectServer.getRequestCategoryList(mContext, object : ConnectServer.jsonResponseHandler{
            override fun onResponse(json: JSONObject) {
                Log.d("카테고리응답", json.toString())
            }

        })
    }
}
