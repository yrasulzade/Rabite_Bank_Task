package com.rabitebank.task.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rabitebank.task.R
import com.rabitebank.task.databinding.ItemSingleChatBinding
import com.rabitebank.task.model.ChatDialogMessage
import com.rabitebank.task.model.DialogMessageType
import com.rabitebank.task.util.CircleTransform
import com.rabitebank.task.util.ClickListener
import com.squareup.picasso.Picasso

class ChatAdapter(
    var messages: ArrayList<ChatDialogMessage>,
    val context: Context,
    val clickListener: ClickListener
) :
    RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    fun updateChatAdapter(messages: ArrayList<ChatDialogMessage>) {
        this.messages=messages
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemSingleChatBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_single_chat,
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = messages[position]

        holder.binding.userName.text = message.userName
        holder.binding.message.text = message.lastMessage
        holder.binding.date.text = message.dateCreated

        if (message.messageType == DialogMessageType.GROUP_CHAT) {
            holder.binding.imageView.visibility = View.GONE
            holder.binding.constraintLayout.visibility = View.VISIBLE
            holder.binding.onlineDot.visibility = View.GONE

            Picasso.get()
                .load(message.userImageUri?.get(0))
                .transform(CircleTransform())
                .into(holder.binding.groupImageFirst)

            Picasso.get()
                .load(message.userImageUri?.get(1))
                .transform(CircleTransform())
                .into(holder.binding.groupImageSecond)
        } else {
            Picasso.get()
                .load(message.userImageUri?.get(0))
                .transform(CircleTransform())
                .into(holder.binding.imageView)

            holder.binding.imageView.visibility = View.VISIBLE
            holder.binding.constraintLayout.visibility = View.GONE
        }
    }

    inner class ViewHolder(val binding: ItemSingleChatBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                clickListener.onClickListener(adapterPosition)
            }
        }
    }
}