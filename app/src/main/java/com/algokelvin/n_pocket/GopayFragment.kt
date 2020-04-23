package com.algokelvin.n_pocket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.algokelvin.utils.db.entity.PocketEntity
import com.algokelvin.utils.recyclerview.setupAdapterData
import com.algokelvin.utils.viewmodel.PocketViewModel
import kotlinx.android.synthetic.main.fragment_money.*
import kotlinx.android.synthetic.main.item_data_pocket.view.*
import java.util.ArrayList

@Suppress("DEPRECATION")
class GopayFragment : Fragment() {
    private val pocketViewModel by lazy {
        ViewModelProviders.of(this).get(PocketViewModel::class.java)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_money, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        titleNoteMoney.text = getString(R.string.note_gopay)

        val listPocketGopay = pocketViewModel.getNotePocket(requireContext(), "gopay") as ArrayList<PocketEntity>
        rvItemPocketMoney.setupAdapterData(R.layout.item_data_pocket, requireContext(), listPocketGopay) {
            data {
                viewItem.descriptionPocket.text = getString(R.string._160_data_description, item?.description)
                viewItem.amountPocket.text = getString(R.string._160_data_amount, item?.amount.toString())
            }
            setLayoutManager(linearLayoutManager(), 0)
            setAdapter()
        }
    }

}