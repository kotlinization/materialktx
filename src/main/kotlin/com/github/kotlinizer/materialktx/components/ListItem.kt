package com.github.kotlinizer.materialktx.components

import com.github.kotlinizer.materialktx.AttributesBoolean
import com.github.kotlinizer.materialktx.AttributesString
import com.github.kotlinizer.materialktx.slot
import kotlinx.html.*

class MwcListItemTag(
    initialAttributes: Map<String, String>,
    override val consumer: TagConsumer<*>
) : HTMLTag(
    tagName = "mwc-list-item",
    consumer = consumer,
    initialAttributes = initialAttributes,
    namespace = null,
    inlineTag = false,
    emptyTag = false
), HtmlBlockTag, ImportListItem {

    companion object {
        const val GRAPHIC_AVATAR = "avatar"
        const val GRAPHIC_ICON = "icon"
        const val GRAPHIC_MEDIUM = "medium"
        const val GRAPHIC_LARGE = "large"
    }

    var activated: Boolean by AttributesBoolean()

    var selected: Boolean by AttributesBoolean()

    var graphic: String? by AttributesString()

    var hasMeta: Boolean by AttributesBoolean()

    var twoline: Boolean by AttributesBoolean()
}

@HtmlTagMarker
inline fun MwcListTag.mwcListItem(
    label: String? = null,
    crossinline block: MwcListItemTag.() -> Unit = {}
) = MwcListItemTag(emptyMap, consumer).apply {
    visit {
        if(label!=null) {
            text(label)
        }
        block()
    }
}

@HtmlTagMarker
inline fun MwcListTag.mwcListItemGraphic(
    graphic: String,
    label: String,
    icon: String,
    crossinline block: MwcListItemTag.() -> Unit = {}
) = MwcListItemTag(emptyMap, consumer).apply {
    visit {
        this.graphic = graphic
        span { text(label) }
        mwcIcon(icon) {
            slot = "graphic"
        }
        block()
    }
}

@HtmlTagMarker
inline fun MwcListTag.mwcListItemMeta(
    label: String,
    icon: String,
    crossinline block: MwcListItemTag.() -> Unit = {}
) = MwcListItemTag(emptyMap, consumer).apply {
    visit {
        hasMeta = true
        span { text(label) }
        mwcIcon(icon) {
            slot = "meta"
        }
        block()
    }
}

@HtmlTagMarker
inline fun MwcListTag.mwcListItemTwoLine(
    firstLine: String,
    secondLine: String,
    crossinline block: MwcListItemTag.() -> Unit = {}
) = MwcListItemTag(emptyMap, consumer).apply {
    visit {
        twoline = true
        span { text(firstLine) }
        span {
            slot = "secondary"
            text(secondLine)
        }
        block()
    }
}

@JsNonModule
@JsModule("@material/mwc-list/mwc-list-item")
private external interface ImportListItem