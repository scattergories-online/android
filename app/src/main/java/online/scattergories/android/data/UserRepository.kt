package online.scattergories.android.data

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.callbackFlow
import online.scattergories.android.models.User

object UserRepository {
    private val collectionID = "users"

    @ExperimentalCoroutinesApi
    fun getUser(id: String) = callbackFlow {
        FirebaseFirestore.getInstance().collection(collectionID).document(id).get()
            .addOnSuccessListener {
                trySend(it.toObject(User::class.java))
            }.addOnFailureListener {
                trySend(null)
            }
    }

    @ExperimentalCoroutinesApi
    fun setUsername(id: String, username: String) {
        println("CALLLLLLLLLLLLED")
        FirebaseFirestore.getInstance().collection(collectionID).document(id)
            .set(mapOf("username" to username)).addOnSuccessListener {
                println("Success")
            }.addOnFailureListener {
                println("Error")
            }
    }
}