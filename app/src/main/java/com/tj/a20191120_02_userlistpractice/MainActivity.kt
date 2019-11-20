package com.tj.a20191120_02_userlistpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tj.a20191120_02_userlistpractice.adapters.UserAdapter
import com.tj.a20191120_02_userlistpractice.datas.User
import com.tj.a20191120_02_userlistpractice.utils.ConnectServer
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : BaseActivity() {

    var userList = ArrayList<User>()
    var userAdapter:UserAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        userListView.setOnItemClickListener { parent, view, position, id ->
            var userData = userList.get(position)
            var intent = Intent(mContext, UserDetailActivity::class.java)
            intent.putExtra("user", userData)
            startActivity(intent)
        }
    }

    override fun setValues() {
        userAdapter = UserAdapter(mContext, userList)
        userListView.adapter = userAdapter
    }

    override fun onResume() {
        super.onResume()

        getUserListFromServer()
    }

    fun getUserListFromServer() {
        ConnectServer.getRequestUserList(mContext, "ALL", object : ConnectServer.jsonResponseHandler{
            override fun onResponse(json: JSONObject) {
                Log.d("사용자목록응답", json.toString())

                var code = json.getInt("code")

                if (code == 200) {
                    var data = json.getJSONObject("data")
                    var userArr = data.getJSONArray("users")

                    userList.clear()

                    for (i in 0..userArr.length()-1) {
                        val userData = User.getUserFromJson(userArr.getJSONObject(i))

                        userList.add(userData)
                    }

                    runOnUiThread {
                        userAdapter?.notifyDataSetChanged()
                    }
                }
            }

        })
    }
}
