package com.yamba.android.presentation.fragment

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.yamba.android.R
import com.yamba.android.databinding.FragmentLoginBinding
import com.yamba.android.framework.viewmodel.LoginViewModel


class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        (activity as AppCompatActivity?)!!.setSupportActionBar(binding.toolbar)
        val actionbar = (activity as AppCompatActivity?)!!.supportActionBar
        actionbar!!.title = "Yamba"
        actionbar!!.setDisplayHomeAsUpEnabled(false)
        actionbar!!.setDisplayShowHomeEnabled(true)




        return binding.root
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        //method to custom onBackPressed in our Fragment
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {

                    val intent = Intent(Intent.ACTION_MAIN)
                    intent.addCategory(Intent.CATEGORY_HOME)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    startActivity(intent)
                    System.exit(0)
                }
            }

        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback)

        binding.connexion.setOnClickListener {
            /*viewModel.message.observe(this, Observer {
                it.getContentIfNotHandled()?.let {
                    Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
                }

            })*/

            findNavController().navigate(R.id.login_to_home)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_inscript, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.inscript -> {

            }
        }

        return super.onOptionsItemSelected(item)
    }


}
