package com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.signupfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.eng_abdelrahmman_hussien.movieapp.R
import com.eng_abdelrahmman_hussien.movieapp.databinding.FragmentSignUpBinding
import com.eng_abdelrahmman_hussien.movieapp.datalayer.model.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : Fragment() {
    private lateinit var signUpBinding:FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        signUpBinding=FragmentSignUpBinding.inflate(inflater,container,false)
        signUpBinding.lifecycleOwner=this
        return signUpBinding.root
    }

    //return all users  username in the DB
    private fun getUsernameList(ls:List<User?>):ArrayList<String?>{
        val listOfusersName:ArrayList<String?> = ArrayList()

        for (userName in ls){
            listOfusersName.add(userName?.user_username)
        }
        return listOfusersName
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn_continue=signUpBinding.btnContinue //when it clicked navigate to setup payment method after user account created successfully
        val signUpVM=ViewModelProvider(this)[SignUpFragmentViewModel::class.java]
        btn_continue.setOnClickListener {

            //collect username and password for user and the system will assign id automatically
            val user_username= signUpBinding.username.editText?.text.toString()
            val user_password=signUpBinding.password.editText?.text.toString()
            val user= User(username = user_username, password = user_password)
           //check that username and password fields are not empty
            if(user_username?.trim()!=""&&user_password?.trim()!=""){

                signUpVM.getUsers()//retrieve all users in db
                signUpVM.users.observe(viewLifecycleOwner, Observer {
                   usersList ->

                    //check that the username is unique
                    //so we will check it by all user username list if not contain this user name then username will be available
                    if (!(getUsernameList(usersList).contains(user.user_username))){

                        //this block will executed when  username is unique
                        //insert user to DB
                        signUpVM.insertUser(user)
                        //navigate to setup payment method
                        it.findNavController().navigate(R.id.action_signUpFragment_to_setUpPaymentFragment)

                    }

                })
            }


        }

    }

}