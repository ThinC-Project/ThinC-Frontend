package com.example.heaven.setting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.heaven.MainActivity
import com.example.heaven.R
import com.example.heaven.contentsList.ContentListActivity
import com.example.heaven.databinding.ActivitySearchBinding
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class SearchActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        findViewById<Button>(R.id.searchBtn).setOnClickListener {

            search()
        }

        findViewById<Button>(R.id.backBtn).setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)

        }

    }

    private fun search() {
        Log.w("login", "login process")
        var search = binding.searchArea.text.toString()
        val url = URL("http://10.0.2.2:8080/search?search=$search")
        Thread{
            try{
                Log.w("connect", "success")

                val connection = url.openConnection() as HttpURLConnection

                val streamReader = InputStreamReader(connection.inputStream)
                val buffered = BufferedReader(streamReader)

                val content = StringBuilder()
                while (true) {
                    val data = buffered.readLine() ?: break
                    content.append(data)
                }

                Log.w("message", content.toString())
                if (content.toString().equals("login success")){
                    val intent = Intent(this, ContentListActivity::class.java)
                    startActivity(intent)
                    finish()
                } else{
                    val handler = Handler(Looper.getMainLooper())
                    handler.postDelayed(Runnable {
                        Toast.makeText(this, "회원 정보가 일치하지 않습니다.", Toast.LENGTH_LONG).show()
                    }, 0)

                }
            }catch (e:Exception){
                e.printStackTrace()
            }
        }.start()

    }
}