package com.projectbounty.projectbounty.Fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.projectbounty.projectbounty.R
import com.projectbounty.projectbounty.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSettingsBinding.inflate(inflater, container, false)

//        Theme Selection
        binding.themeBtn.setOnClickListener() {
            showThemeDialog()
        }

//        Edit Profile
        binding.editProfileBtn.setOnClickListener {
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_settingsFragment_to_profileFragment)
        }

//        Checking for update
        binding.checkForUpdateBtn.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_bottomSheetFragment)
        }


        return binding.root
    }

    private fun showThemeDialog() {
        val sharedPreferences =
            requireContext().getSharedPreferences("itemPos", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        val getShared = requireContext().getSharedPreferences("itemPos", Context.MODE_PRIVATE)
        val itemPos = getShared.getInt("itemPos", 0)

        val items = arrayOf("System Default", "Light", "Dark")
        MaterialAlertDialogBuilder(requireContext(), R.style.MaterialAlertDialog_Rounded)
            .setTitle("Choose app theme")
            .setPositiveButton(
                "Cancel"
            ) { dialog, which -> dialog.dismiss() }
            .setSingleChoiceItems(
                items, itemPos
            ) { dialog, which ->
                when (which) {
                    1 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    2 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    0 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                    else -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                }
                editor.putInt("itemPos", which)
                editor.apply()
                dialog.dismiss()
            }
            .setCancelable(true)
            .show()
    }

}