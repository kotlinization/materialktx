package com.github.kotlinizer.materialktx.components

import com.github.kotlinizer.materialktx.AttributesBoolean
import kotlinx.html.*


class MwcCheckListItem(
    initialAttributes: Map<String, String>,
    override val consumer: TagConsumer<*>
) : HTMLTag(
    tagName = "mwc-check-list-item",
    consumer = consumer,
    initialAttributes = initialAttributes,
    namespace = null,
    inlineTag = false,
    emptyTag = false
), HtmlBlockTag, ImportCheckListItem {

    var selected: Boolean by AttributesBoolean()

    var left: Boolean by AttributesBoolean()


}

@HtmlTagMarker
inline fun MwcListTag.mwcCheckListItem(
    label: String? = null,
    crossinline block: MwcCheckListItem.() -> Unit = {}
) = MwcCheckListItem(emptyMap, consumer).apply {
    visit {
        if (label != null) {
            text(label)
        }
        block()
    }
}


@JsNonModule
@JsModule("@material/mwc-list/mwc-check-list-item")
private external interface ImportCheckListItem