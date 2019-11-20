package com.tj.a20191120_02_userlistpractice.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.tj.a20191120_02_userlistpractice.R
import com.tj.a20191120_02_userlistpractice.datas.User

class UserAdapter(context: Context, res:Int, list: ArrayList<User>) : ArrayAdapter<User>(context, res, list) {

    var mContext = context
    var mList = list
    var inf = LayoutInflater.from(mContext)

    constructor(context: Context, list: ArrayList<User>) : this (context, R.layout.user_list_item, list)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        if (tempRow == null) {
            tempRow = inf.inflate(R.layout.user_list_item, null)
        }

        var row = tempRow!!

        var user = mList.get(position)

        var userNameTxt = row.findViewById<TextView>(R.id.userNameTxt)
        var userIdTxt = row.findViewById<TextView>(R.id.userIdTxt)
        var categoryColorImg = row.findViewById<ImageView>(R.id.categoryColorImg)

        userNameTxt.text = user.name
        userIdTxt.text = "(${user.loginId})"
        categoryColorImg.setBackgroundColor(Color.parseColor(user.category?.color))

        return row
    }
}