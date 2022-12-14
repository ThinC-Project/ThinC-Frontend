package com.example.heaven.freeBoard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.heaven.R
import com.example.heaven.utils.FBAuth

import com.example.heaven.utils.FBRef
import com.bumptech.glide.Glide
import com.example.heaven.databinding.ActivityFreeBoardEditBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class FreeBoardEditActivity : AppCompatActivity() {

    private lateinit var key:String

    private lateinit var binding : ActivityFreeBoardEditBinding

    private val TAG = FreeBoardEditActivity::class.java.simpleName

    private lateinit var writerUid : String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_free_board_edit)

        key = intent.getStringExtra("key").toString()
        getBoardData(key)
        getImageData(key)

        binding.editBtn.setOnClickListener {
            editBoardData(key)
        }


    }

    private fun editBoardData(key : String){

//        FBRef.boardRef
//            .child(key)
//            .setValue(
//                FreeBoardModel(binding.titleArea.text.toString(),
//                    binding.contentArea.text.toString(),
//                    writerUid,
//                    FBAuth.getTime())
//            )

        Toast.makeText(this, "수정완료", Toast.LENGTH_LONG).show()

        finish()

    }

    private fun getImageData(key : String){

        // Reference to an image file in Cloud Storage
//        val storageReference = Firebase.storage.reference.child(key + ".png")
//
//        // ImageView in your Activity
//        val imageViewFromFB = binding.imageArea
//
//        storageReference.downloadUrl.addOnCompleteListener(OnCompleteListener { task ->
//            if(task.isSuccessful) {
//
//                Glide.with(this)
//                    .load(task.result)
//                    .into(imageViewFromFB)
//
//            } else {
//
//            }
//        })


    }

    private fun getBoardData(key : String){

//        val postListener = object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//
//                val dataModel = dataSnapshot.getValue(FreeBoardModel::class.java)
//
//                binding.titleArea.setText(dataModel?.title)
//                binding.contentArea.setText(dataModel?.content)
//                writerUid = dataModel!!.uid
//
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {
//                // Getting Post failed, log a message
//                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
//            }
//        }
//        FBRef.boardRef.child(key).addValueEventListener(postListener)
    }

}