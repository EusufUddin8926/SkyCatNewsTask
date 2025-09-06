import org.task.skycatnews.features.story_details.data.dto.HeroImageDto
import org.task.skycatnews.features.story_details.data.dto.StoryContentDto
import org.task.skycatnews.features.story_details.data.dto.StoryDetailDto

object StoryDetailMockData {
    val mockStoryDto = StoryDetailDto(
        id = "1",
        headline = "Story Headline",
        heroImage = HeroImageDto(
            imageUrl = "",
            accessibilityText = "Image Placeholder"
        ),
        creationDate = "2020-11-18T00:00:00Z",
        modifiedDate = "2020-11-19T00:00:00Z",
        contents = listOf(
            StoryContentDto.Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
            StoryContentDto.Paragraph("Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
            StoryContentDto.Image("", "Image Placeholder"),
            StoryContentDto.Paragraph("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo."),
            StoryContentDto.Image("", "Image Placeholder"),
            StoryContentDto.Paragraph("Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nescunt.")
        )
    )
}