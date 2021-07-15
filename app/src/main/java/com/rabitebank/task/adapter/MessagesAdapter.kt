package com.rabitebank.task.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rabitebank.task.R
import com.rabitebank.task.databinding.ItemMessageMeBinding
import com.rabitebank.task.databinding.ItemMessageUserBinding
import com.rabitebank.task.model.Message
import com.rabitebank.task.model.MessageType
import com.rabitebank.task.util.CircleTransform
import com.rabitebank.task.util.RoundCornersTransform
import com.squareup.picasso.Picasso

class MessagesAdapter(
    var messages: ArrayList<Message>,
    val context: Context
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val IS_ME = 1
    private val USER = 2
    val TAG = "MessagesAdapter"

    fun updateMessagesAdapter(messages: ArrayList<Message>) {
        this.messages = messages
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == IS_ME) {
            Log.d(TAG, "onCreateViewHolder: IS_ME")
            val binding: ItemMessageMeBinding =
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_message_me,
                    parent,
                    false
                )
            return MeViewHolder(binding)
        } else {
            Log.d(TAG, "onCreateViewHolder: ELSE")
            val binding: ItemMessageUserBinding =
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_message_user,
                    parent,
                    false
                )
            return UserViewHolder(binding)
        }
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    override fun getItemViewType(position: Int): Int {
        val item: Message = messages[position]
        return if (item.isMe) {
            IS_ME
        } else {
            USER
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = messages[position]

        if (message.isMe) {
            initMeLayout(holder as MeViewHolder, position)
        } else {
            initUserLayout(holder as UserViewHolder, position)
        }
    }

    private fun initMeLayout(holder: MeViewHolder, position: Int) {
        val message = messages[position]
        holder.binding.meMessage.text = message.message


        Picasso.get().load("https://media.istockphoto.com/photos/smiling-indian-man-looking-at-camera-picture-id1270067126?b=1&k=6&m=1270067126&s=170667a&w=0&h=ORPL0Z6kn8TSL3ObkcvmGB8wU5v2BI_1ZnLEiFUI32U=")
            .transform(CircleTransform())
            .into(holder.binding.myImage)

        if (message.messageType==MessageType.TEXT){
            holder.binding.imageView.visibility= View.GONE
            holder.binding.chatBubble.visibility= View.VISIBLE
        }else{
            Picasso.get().load(message.message)
                .transform(RoundCornersTransform(30.0f))
                .into(holder.binding.imageView)

            holder.binding.imageView.visibility= View.VISIBLE
            holder.binding.chatBubble.visibility= View.GONE
        }
    }

    private fun initUserLayout(holder: UserViewHolder, position: Int) {
        val message = messages[position]
        holder.binding.userMessage.text = message.message

        Picasso.get().load("https://sa1s3optim.patientpop.com/assets/images/provider/photos/1888657.jpg")
            .transform(CircleTransform())
            .into(holder.binding.userImage)
    }

    inner class MeViewHolder(val binding: ItemMessageMeBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class UserViewHolder(val binding: ItemMessageUserBinding) :
        RecyclerView.ViewHolder(binding.root)
}