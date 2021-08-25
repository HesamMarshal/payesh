package ir.hesammarshal.payesh.view.activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import ir.hesammarshal.payesh.R
import ir.hesammarshal.payesh.databinding.ActivityAddUpdateItemBinding
import ir.hesammarshal.payesh.databinding.DialogCustomListBinding
import ir.hesammarshal.payesh.utils.Constants
import ir.hesammarshal.payesh.view.adapters.CustomListItemAdapter


class AddUpdateItemActivity : AppCompatActivity() , View.OnClickListener {
    // TODO: Add Heart Logo or image in add screen


    private lateinit var mBinding:ActivityAddUpdateItemBinding

    // To Store Value
    private lateinit var mCustomListDialog : Dialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityAddUpdateItemBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setupActionBar()

        mBinding.etSystolic.setOnClickListener(this)
        mBinding.etDiastolic.setOnClickListener(this)
        mBinding.etPulse.setOnClickListener(this)
        // TODO: Change to Heart ????
        mBinding.btnAddItem.setOnClickListener(this)
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
                R.id.btn_add_item ->{
                    val varDate = mBinding.etDate.text.toString().trim{ it <= ' '}
                    val varTime = mBinding.etTime.text.toString().trim{ it <= ' '}
                    val varSystolic = mBinding.etSystolic.text.toString().trim{ it <= ' '}
                    val varDiastolic = mBinding.etDiastolic.text.toString().trim{ it <= ' '}
                    val varPulse = mBinding.etPulse.text.toString().trim{ it <= ' '}
                    when {
                        TextUtils.isEmpty(varDate) -> {
                            Toast.makeText(this@AddUpdateItemActivity,
                                resources.getString(R.string.err_msg_select_heart_date),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        TextUtils.isEmpty(varTime) -> {
                            Toast.makeText(this@AddUpdateItemActivity,
                                resources.getString(R.string.err_msg_select_heart_time),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        TextUtils.isEmpty(varSystolic) -> {
                            Toast.makeText(this@AddUpdateItemActivity,
                                resources.getString(R.string.err_msg_select_heart_systloic),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        TextUtils.isEmpty(varDiastolic) -> {
                            Toast.makeText(this@AddUpdateItemActivity,
                                resources.getString(R.string.err_msg_select_heart_diastolic),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        TextUtils.isEmpty(varPulse) -> {
                            Toast.makeText(this@AddUpdateItemActivity,
                                resources.getString(R.string.err_msg_select_heart_pulse),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        else -> {
                            Toast.makeText(this@AddUpdateItemActivity,
                                "All the entries are valid.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }


                }
            }
        }
    }


    private fun customItemsListDialog(title: String, itemList:List<String>, selection: String){
        mCustomListDialog = Dialog(this)
        val binding : DialogCustomListBinding = DialogCustomListBinding.inflate(layoutInflater)

        mCustomListDialog.setContentView(binding.root)
        binding.tvTitle.text = title
        binding.rvList.layoutManager = LinearLayoutManager(this)

        val adapter = CustomListItemAdapter(this, itemList,selection)
        binding.rvList.adapter = adapter
        mCustomListDialog.show()
    }

    // To retrive the slected value from User and store in Edit Box
    fun selectedListItem(item: String, selection: String) {
        when (selection){
            Constants.HEART_SYSTOLIC ->{
                mCustomListDialog.dismiss()
                mBinding.etSystolic.setText(item)
            }
            Constants.HEART_DIASTOLIC ->{
                mCustomListDialog.dismiss()
                mBinding.etDiastolic.setText(item)
            }
            Constants.HEART_PULSE ->{
                mCustomListDialog.dismiss()
                mBinding.etPulse .setText(item)
            }

        }
    }

    // TODO: Not need for now
    companion object{
        private const val CAMERA = 1
        private const val GALLERY = 2
        private const val IMAGE_DIRECTORY = "FavDishImages"
    }
}