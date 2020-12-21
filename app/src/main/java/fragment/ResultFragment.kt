package fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lovetest.R
import kotlinx.android.synthetic.main.fragment_result.*


class ResultFragment : Fragment() {

    var option = -1
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        option = arguments?.getInt("index")?:-1  // null이면 -1 반환   /  엘비스 연산자!

        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        setResult(option)

        btn_goto_home.setOnClickListener {
            navController.navigate(R.id.action_resultFragment_to_mainFragment)
        }
    }

    fun setResult(option:Int){
        when(option){
            1 -> {
                // setText 기능
                result_text1.text = "You are a Quitter"
                result_text2.text = "You can let the person easily."
            }
            2 -> {
                result_text1.text = "You should focus on yourself"
                result_text2.text = "You become really clingly to your ex."
            }
            3 -> {
                result_text1.text = "You should take it easy"
                result_text2.text = "You can do crazy things no matter what it takes."
            }
            4 -> {
                result_text1.text = "You are pretty mature"
                result_text2.text = "You can easily accept the break-up"
            }

        }
    }

}