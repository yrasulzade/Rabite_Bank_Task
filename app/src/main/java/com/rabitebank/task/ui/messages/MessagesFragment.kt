package com.rabitebank.task.ui.messages

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rabitebank.task.R
import com.rabitebank.task.adapter.MessagesAdapter
import com.rabitebank.task.base.BaseFragment
import com.rabitebank.task.databinding.FragmentMessagesBinding
import com.rabitebank.task.model.Message
import com.rabitebank.task.model.MessageType
import com.rabitebank.task.util.ClickListener
import com.rabitebank.task.util.DumbData
import kotlin.collections.ArrayList

class MessagesFragment : BaseFragment<FragmentMessagesBinding, MessagesViewModel>() {
    val TAG = "MessagesFragment"
    private lateinit var viewModel: MessagesViewModel
    private lateinit var binding: FragmentMessagesBinding
    var messages = ArrayList<Message>()
    private var messageAdapter: MessagesAdapter? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_messages
    }

    override fun getViewModel(): MessagesViewModel {
        viewModel = ViewModelProvider(this).get(MessagesViewModel::class.java)
        return viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = viewDataBinding!!

        binding.backArrow.setOnClickListener { findNavController().popBackStack() }

        binding.send.setOnClickListener {
            if (binding.typeMessage.text.isNotEmpty()) {
                val message = binding.typeMessage.text.toString()
                messages.add(Message(message, true, MessageType.TEXT))
                messageAdapter?.notifyDataSetChanged()
                binding.chatRecyclerView.smoothScrollToPosition(messages.size - 1)
                binding.typeMessage.setText("")
            }
        }


        viewModel.messages.observe(viewLifecycleOwner, { messages ->
            this.messages.addAll(messages)
            messageAdapter?.notifyDataSetChanged()
            binding.chatRecyclerView.smoothScrollToPosition(messages.size - 1)
        })

        initChatRecyclerView()
    }

    private fun initChatRecyclerView() {
        messageAdapter = MessagesAdapter(messages, requireContext());
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.chatRecyclerView.setHasFixedSize(true)
        binding.chatRecyclerView.layoutManager = layoutManager
        binding.chatRecyclerView.adapter = messageAdapter
    }
}