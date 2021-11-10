package com.example.libimgur.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GalleryResponse(
    @Json(name = "data")
    val `data`: List<Data?>?,
    @Json(name = "status")
    val status: Int?,
    @Json(name = "success")
    val success: Boolean?
) {
    @JsonClass(generateAdapter = true)
    data class Data(
        @Json(name = "account_id")
        val accountId: Int?,
        @Json(name = "account_url")
        val accountUrl: String?,
        @Json(name = "ad_config")
        val adConfig: AdConfig?,
        @Json(name = "ad_type")
        val adType: Int?,
        @Json(name = "ad_url")
        val adUrl: String?,
        @Json(name = "animated")
        val animated: Boolean?,
        @Json(name = "bandwidth")
        val bandwidth: Long?,
        @Json(name = "comment_count")
        val commentCount: Int?,
        @Json(name = "cover")
        val cover: String?,
        @Json(name = "cover_height")
        val coverHeight: Int?,
        @Json(name = "cover_width")
        val coverWidth: Int?,
        @Json(name = "datetime")
        val datetime: Int?,
        @Json(name = "description")
        val description: Any?,
        @Json(name = "downs")
        val downs: Int?,
        @Json(name = "edited")
        val edited: Int?,
        @Json(name = "favorite")
        val favorite: Boolean?,
        @Json(name = "favorite_count")
        val favoriteCount: Int?,
        @Json(name = "gifv")
        val gifv: String?,
        @Json(name = "has_sound")
        val hasSound: Boolean?,
        @Json(name = "height")
        val height: Int?,
        @Json(name = "hls")
        val hls: String?,
        @Json(name = "id")
        val id: String?,
        @Json(name = "images")
        val images: List<Image?>?,
        @Json(name = "images_count")
        val imagesCount: Int?,
        @Json(name = "in_gallery")
        val inGallery: Boolean?,
        @Json(name = "in_most_viral")
        val inMostViral: Boolean?,
        @Json(name = "include_album_ads")
        val includeAlbumAds: Boolean?,
        @Json(name = "is_ad")
        val isAd: Boolean?,
        @Json(name = "is_album")
        val isAlbum: Boolean?,
        @Json(name = "layout")
        val layout: String?,
        @Json(name = "link")
        val link: String?,
        @Json(name = "mp4")
        val mp4: String?,
        @Json(name = "mp4_size")
        val mp4Size: Int?,
        @Json(name = "nsfw")
        val nsfw: Boolean?,
        @Json(name = "points")
        val points: Int?,
        @Json(name = "privacy")
        val privacy: String?,
        @Json(name = "processing")
        val processing: Processing?,
        @Json(name = "score")
        val score: Int?,
        @Json(name = "section")
        val section: String?,
        @Json(name = "size")
        val size: Int?,
        @Json(name = "tags")
        val tags: List<Tag?>?,
        @Json(name = "title")
        val title: String?,
        @Json(name = "topic")
        val topic: Any?,
        @Json(name = "topic_id")
        val topicId: Any?,
        @Json(name = "type")
        val type: String?,
        @Json(name = "ups")
        val ups: Int?,
        @Json(name = "views")
        val views: Int?,
        @Json(name = "vote")
        val vote: Any?,
        @Json(name = "width")
        val width: Int?
    ) {
        @JsonClass(generateAdapter = true)
        data class AdConfig(
            @Json(name = "highRiskFlags")
            val highRiskFlags: List<Any?>?,
            @Json(name = "safeFlags")
            val safeFlags: List<String?>?,
            @Json(name = "showsAds")
            val showsAds: Boolean?,
            @Json(name = "unsafeFlags")
            val unsafeFlags: List<String?>?,
            @Json(name = "wallUnsafeFlags")
            val wallUnsafeFlags: List<Any?>?
        )

        @JsonClass(generateAdapter = true)
        data class Image(
            @Json(name = "account_id")
            val accountId: Any?,
            @Json(name = "account_url")
            val accountUrl: Any?,
            @Json(name = "ad_type")
            val adType: Int?,
            @Json(name = "ad_url")
            val adUrl: String?,
            @Json(name = "animated")
            val animated: Boolean?,
            @Json(name = "bandwidth")
            val bandwidth: Long?,
            @Json(name = "comment_count")
            val commentCount: Any?,
            @Json(name = "datetime")
            val datetime: Int?,
            @Json(name = "description")
            val description: String?,
            @Json(name = "downs")
            val downs: Any?,
            @Json(name = "edited")
            val edited: String?,
            @Json(name = "favorite")
            val favorite: Boolean?,
            @Json(name = "favorite_count")
            val favoriteCount: Any?,
            @Json(name = "gifv")
            val gifv: String?,
            @Json(name = "has_sound")
            val hasSound: Boolean?,
            @Json(name = "height")
            val height: Int?,
            @Json(name = "hls")
            val hls: String?,
            @Json(name = "id")
            val id: String?,
            @Json(name = "in_gallery")
            val inGallery: Boolean?,
            @Json(name = "in_most_viral")
            val inMostViral: Boolean?,
            @Json(name = "is_ad")
            val isAd: Boolean?,
            @Json(name = "link")
            val link: String?,
            @Json(name = "looping")
            val looping: Boolean?,
            @Json(name = "mp4")
            val mp4: String?,
            @Json(name = "mp4_size")
            val mp4Size: Int?,
            @Json(name = "nsfw")
            val nsfw: Any?,
            @Json(name = "points")
            val points: Any?,
            @Json(name = "processing")
            val processing: Processing?,
            @Json(name = "score")
            val score: Any?,
            @Json(name = "section")
            val section: Any?,
            @Json(name = "size")
            val size: Int?,
            @Json(name = "tags")
            val tags: List<Any?>?,
            @Json(name = "title")
            val title: Any?,
            @Json(name = "type")
            val type: String?,
            @Json(name = "ups")
            val ups: Any?,
            @Json(name = "views")
            val views: Int?,
            @Json(name = "vote")
            val vote: Any?,
            @Json(name = "width")
            val width: Int?
        ) {
            @JsonClass(generateAdapter = true)
            data class Processing(
                @Json(name = "status")
                val status: String?
            )
        }

        @JsonClass(generateAdapter = true)
        data class Processing(
            @Json(name = "status")
            val status: String?
        )

        @JsonClass(generateAdapter = true)
        data class Tag(
            @Json(name = "accent")
            val accent: String?,
            @Json(name = "background_hash")
            val backgroundHash: String?,
            @Json(name = "background_is_animated")
            val backgroundIsAnimated: Boolean?,
            @Json(name = "description")
            val description: String?,
            @Json(name = "description_annotations")
            val descriptionAnnotations: DescriptionAnnotations?,
            @Json(name = "display_name")
            val displayName: String?,
            @Json(name = "followers")
            val followers: Int?,
            @Json(name = "following")
            val following: Boolean?,
            @Json(name = "is_promoted")
            val isPromoted: Boolean?,
            @Json(name = "is_whitelisted")
            val isWhitelisted: Boolean?,
            @Json(name = "logo_destination_url")
            val logoDestinationUrl: Any?,
            @Json(name = "logo_hash")
            val logoHash: Any?,
            @Json(name = "name")
            val name: String?,
            @Json(name = "thumbnail_hash")
            val thumbnailHash: String?,
            @Json(name = "thumbnail_is_animated")
            val thumbnailIsAnimated: Boolean?,
            @Json(name = "total_items")
            val totalItems: Int?
        ) {
            @JsonClass(generateAdapter = true)
            class DescriptionAnnotations
        }
    }
}