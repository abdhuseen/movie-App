package com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.displayplanfeaturesfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.eng_abdelrahmman_hussien.movieapp.R
import com.eng_abdelrahmman_hussien.movieapp.databinding.FragmentDisplayPlanBinding

class DisplayPlanFeaturesFragment : Fragment() {
private lateinit var displayBinding:FragmentDisplayPlanBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        displayBinding=FragmentDisplayPlanBinding.inflate(inflater,container,false)
        displayBinding.lifecycleOwner=this
        return displayBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val displayVm=ViewModelProvider(this)[DisplayPlanFeaturesFragmentViewModel::class.java]
        //images to show true icons inside each feature,while each text view at layout contain the feature
        val img1=displayBinding.imgPoint1
        val img2=displayBinding.imgPoint2
        val img3=displayBinding.imgPoint3
        val img_ls= listOf(img1,img2,img3)
        displayVm.getImages(img_ls)
        displayVm.imagesList.observe(viewLifecycleOwner){

            it.forEach {
               img ->  img.setImageResource(R.drawable.checked)
            }
        }

        //navigate to see subscription plans fragment
        val btn_seePlans=displayBinding.btnSeePlans
        btn_seePlans.setOnClickListener {
            it.findNavController().navigate(R.id.action_dispalyPlanFeaturesFragment_to_choosePlanFragment)
        }

    }
}