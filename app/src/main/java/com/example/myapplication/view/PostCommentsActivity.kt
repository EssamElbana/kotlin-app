package com.example.myapplication.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.model.Comment
import com.example.myapplication.repository.IRepository
import com.example.myapplication.repository.Repository
import kotlinx.android.synthetic.main.activity_post_comments.*


class PostCommentsActivity : AppCompatActivity() {
    private val repository: IRepository = Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_comments)

        val postId: Int = intent.extras?.get("POST_ID") as Int

        repository.getPostComments(postId, object : IRepository.Callback<List<Comment>> {
            override fun onSuccess(response: List<Comment>) {
                val comments = response

                for (comment in comments) {
                    var text = ""
                    text += "PostId: ${comment.postId} \n" +
                            "Id: ${comment.id} \n" +
                            "Name: ${comment.name} \n" +
                            "email: ${comment.email} \n" +
                            "text: ${comment.text} \n\n"
                    posts_comments.append(text)
                }
            }

            override fun onFailure(errorMessage: String) {
                Toast.makeText(this@PostCommentsActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}