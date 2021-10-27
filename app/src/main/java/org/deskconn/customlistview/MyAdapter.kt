package org.deskconn.customlistview

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(private val context: Activity, private val arrayList: ArrayList<User>): ArrayAdapter<User>(context,
                R.layout.list_item, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.list_item, null)

        val imageView: ImageView = view.findViewById(R.id.profilePic)
        val userName: TextView = view.findViewById(R.id.personName)
        val lastMessage: TextView = view.findViewById(R.id.lastMessage)
        val lasMsgTime: TextView = view.findViewById(R.id.messageTime)

        imageView.setImageResource(arrayList[position].imageId)
        userName.text = arrayList[position].name
        lastMessage.text = arrayList[position].lastMessage
        lasMsgTime.text = arrayList[position].lastMessageTime

        return view
    }
}