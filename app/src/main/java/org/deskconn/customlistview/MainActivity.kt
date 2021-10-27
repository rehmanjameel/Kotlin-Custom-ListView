package org.deskconn.customlistview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import org.deskconn.customlistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userArrayList: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(

            R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
            R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i
        )

        val name = arrayOf(
            "Ajmal", "Ahmad", "Wajahat", "Saddi", "Sami", "Aqdas",
            "Salman", "Tahir", "Abdul Rehman"
        )

        val lastMessage = arrayOf(
            "Hye!", "How are you?", "Whats going on?", "Call me",
            "Busy", "I'm in meeting", "Let's go", "On the way", "At home"
        )

        val lastMsgTime = arrayOf(
            "8:50 pm", "8:45 pm", "7:45 pm", "5:45 pm", "4:45 pm", "3:45 pm",
            "2:45 pm", "1:45 pm", "0:45 pm"
        )

        val contactNo = arrayOf(
            "03080734576", "03080734576", "03080734576", "03080734576", "03080734576", "03080734576",
            "03080734576", "03080734576", "03080734576"
        )

        val country = arrayOf(
            "Pakistan", "Pakistan", "Pakistan", "Pakistan", "Pakistan", "Pakistan",
            "Pakistan", "Pakistan", "Pakistan"
        )

        userArrayList = ArrayList()

        for (i in name.indices){
            val user = User(name[i], lastMessage[i], lastMsgTime[i], contactNo[i], country[i], imageId[i])
            userArrayList.add(user)
        }

        binding.listView.isClickable = true
        binding.listView.adapter = MyAdapter(this, userArrayList)
        binding.listView.setOnItemClickListener { parent, view, position, id ->

            val name = name[position]
            val contact = contactNo[position]
            val country = country[position]
            val imageId = imageId[position]

            val i = Intent(this, UserActivity::class.java)
            i.putExtra("name", name)
            i.putExtra("phone", contact)
            i.putExtra("country", country)
            i.putExtra("imageId", imageId)
            startActivity(i)
        }
    }
}