package ir.hesammarshal.payesh.view.activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import ir.hesammarshal.payesh.R
import ir.hesammarshal.payesh.databinding.ActivityAddUpdateItemBinding
import ir.hesammarshal.payesh.databinding.DialogCustomListBinding
import ir.hesammarshal.payesh.utils.Constants
import ir.hesammarshal.payesh.view.adapters.CustomListItemAdapter


class AddUpdateItemActivity : AppCompatActivity() , View.OnClickListener {
    // TODO: Add Heart Logo or image in add screen


    private lateinit var mBinding:ActivityAddUpdateItemBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityAddUpdateItemBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setupActionBar()

        //mBinding.ivAddDishImage.setOnClickListener(this)

        mBinding.etSystolic.setOnClickListener(this)
        mBinding.etDiastolic.setOnClickListener(this)
        mBinding.etPulse.setOnClickListener(this)
    }
    private fun setupActionBar(){
        setSupportActionBar(mBinding.toolbarAddHeartActivity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mBinding.toolbarAddHeartActivity.setNavigationOnClickListener {
            onBackPressed()

        }
    }

    override fun onClick(v: View?) {  // Dont forget to Inherit from View.OnClickListener
        if (v != null) {
            when (v.id){
                R.id.et_systolic ->{
                    customItemsListDialog(resources.getString(R.string.title_select_heart_systolic),
                        Constants.heartSystolic(),
                        Constants.HEART_SYSTOLIC)
                    return
                }
                R.id.et_diastolic ->{
                    customItemsListDialog(resources.getString(R.string.title_select_heart_diastolic),
                        Constants.heartDiastolic(),
                        Constants.HEART_DIASTOLIC)
                    return
                }
                R.id.et_pulse ->{
                    customItemsListDialog(resources.getString(R.string.title_select_heart_pulse),
                        Constants.heartPulse(),
                        Constants.HEART_PULSE)
                    return
                }
            }
        }
    }


    private fun customItemsListDialog(title: String, itemList:List<String>, selection: String){
        val customListDialog = Dialog(this)
        val binding : DialogCustomListBinding = DialogCustomListBinding.inflate(layoutInflater)

        customListDialog.setContentView(binding.root)
        binding.tvTitle.text = title
        binding.rvList.layoutManager = LinearLayoutManager(this)

        val adapter = CustomListItemAdapter(this, itemList,selection)
        binding.rvList.adapter = adapter
        customListDialog.show()


    }


    // TODO: Not need for now
    companion object{
        private const val CAMERA = 1
        private const val GALLERY = 2
        private const val IMAGE_DIRECTORY = "FavDishImages"
    }
}