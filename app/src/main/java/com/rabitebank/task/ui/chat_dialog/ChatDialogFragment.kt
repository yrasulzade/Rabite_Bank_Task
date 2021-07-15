package com.rabitebank.task.ui.chat_dialog

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rabitebank.task.R
import com.rabitebank.task.adapter.ChatAdapter
import com.rabitebank.task.adapter.FrequentlyUsersDialogAdapter
import com.rabitebank.task.base.BaseFragment
import com.rabitebank.task.databinding.FragmentChatDialogBinding
import com.rabitebank.task.model.ChatDialogMessage
import com.rabitebank.task.util.ClickListener
import com.rabitebank.task.util.DumbData.getFrequentlyChattedUsers
import java.util.*
import kotlin.collections.ArrayList


class ChatDialogFragment : BaseFragment<FragmentChatDialogBinding, ChatDialogViewModel>(),
    ClickListener {
    val TAG = "ChatDialogFragment"
    private lateinit var viewModel: ChatDialogViewModel
    private lateinit var binding: FragmentChatDialogBinding
    private var chatAdapter: ChatAdapter? = null
    var lastMessages = ArrayList<ChatDialogMessage>()

    override fun getLayoutId(): Int {
        return R.layout.fragment_chat_dialog
    }

    override fun getViewModel(): ChatDialogViewModel {
        viewModel = ViewModelProvider(this).get(ChatDialogViewModel::class.java)
        return viewModel
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = viewDataBinding!!

        viewModel.lastMessages.observe(viewLifecycleOwner, { messages ->
            lastMessages.clear()
            lastMessages.addAll(messages)
            chatAdapter?.updateChatAdapter(lastMessages)
        })

        viewModel.filteredMessages.observe(viewLifecycleOwner, { messages ->
            chatAdapter?.updateChatAdapter(messages)
        })

        binding.search.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                Log.d(TAG, "afterTextChanged: $s")
                viewModel.filter(s.toString(), lastMessages)
            }
        })

        binding.search.setOnTouchListener(OnTouchListener { _, event ->
            val drawableRight = 2
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= binding.search.right - binding.search.compoundDrawables[drawableRight].bounds.width()
                ) {

                    if (binding.search.text.isNotEmpty()) {
                        binding.search.setText("")
                        viewModel.getLastMessages()
                        baseActivity.hideKeyboard()
                        binding.search.clearFocus()
                    }
                    return@OnTouchListener true
                }
            }
            false
        })

        initChatRecyclerView()
        initFrequentlyUsersRecyclerView()
    }

    private fun initChatRecyclerView() {
        chatAdapter = ChatAdapter(lastMessages, requireContext(), this);
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.chatRecyclerView.setHasFixedSize(true)
        binding.chatRecyclerView.layoutManager = layoutManager
        binding.chatRecyclerView.adapter = chatAdapter
    }

    private fun initFrequentlyUsersRecyclerView() {
        val chatAdapter = FrequentlyUsersDialogAdapter(getFrequentlyChattedUsers(),requireContext(), this)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.frequentlyRecyclerView.setHasFixedSize(true)
        binding.frequentlyRecyclerView.layoutManager = layoutManager
        binding.frequentlyRecyclerView.adapter = chatAdapter
    }

    override fun onClickListener(index: Int) {
        findNavController().navigate(R.id.action_chatDialogFragment_to_messagesFragment)
    }
}