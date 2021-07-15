package com.rabitebank.task.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rabitebank.task.R
import com.rabitebank.task.databinding.ItemFrequentUserBinding
import com.rabitebank.task.model.FrequentlyChattedUser
import com.rabitebank.task.util.CircleTransform
import com.rabitebank.task.util.ClickListener
import com.squareup.picasso.Picasso


class FrequentlyUsersDialogAdapter(
    private val frequentlyChattedUsers: ArrayList<FrequentlyChattedUser>,
    val context: Context,
    val clickListener: ClickListener
) :
    RecyclerView.Adapter<FrequentlyUsersDialogAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemFrequentUserBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_frequent_user,
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return frequentlyChattedUsers.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = frequentlyChattedUsers[position]

        holder.binding.name.text = user.userName
        Picasso.get()
            .load(user.userImageUri)
            .transform(CircleTransform())
            .into(holder.binding.imageView)

    }

    inner class ViewHolder(val binding: ItemFrequentUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                clickListener.onClickListener(adapterPosition)
            }
        }
    }
}