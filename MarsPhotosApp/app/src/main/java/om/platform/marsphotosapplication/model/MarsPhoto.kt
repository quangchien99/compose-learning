package om.platform.marsphotosapplication.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This data class defines a Mars photo which includes an ID, and the image URL.
 */
@Serializable
data class MarsPhoto(
    @SerialName("id")
    val id: String,
    @SerialName("img_src")
    val imgSrc: String
)