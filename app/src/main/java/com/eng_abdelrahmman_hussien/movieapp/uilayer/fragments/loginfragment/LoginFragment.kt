package com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.loginfragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.eng_abdelrahmman_hussien.movieapp.R
import com.eng_abdelrahmman_hussien.movieapp.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var loginBinding:FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        loginBinding=FragmentLoginBinding.inflate(inflater,container,false)
        loginBinding.lifecycleOwner=this
        return loginBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val logoimg=loginBinding.imgLogo
        logoimg.setImageResource(R.drawable.app_logo)//show app logo in  layout
        val btn_login=loginBinding.btnLogin
        val loginVM=ViewModelProvider(this)[LoginFragmentViewModel::class.java]
        btn_login.setOnClickListener {
            //when user clicked login button , we retrieve username and password of the user
            val txtUserName=loginBinding.usernameLogin.editText?.text.toString()
            val txtPassword=loginBinding.passwordLogin.editText?.text.toString()
            val con  = this@LoginFragment.requireContext().applicationContext
            //check if user account exist in local db (movie_database)
            loginVM.getUser(txtUserName,txtPassword)//retrieve user from db

            loginVM.user.observe(viewLifecycleOwner){
              user->
                //if user has account the app will store user data in datastore and then  navigate user to home activity
                if (user!=null){

                    loginVM.insertUserData(con,user)//insert user data to data store
                    it.findNavController().navigate(R.id.action_loginFragment2_to_homeActivity2)
                }
            }



        }
    }
}