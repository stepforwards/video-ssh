<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhouyc
  Date: 2017/6/30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>


<div class="intro">
	<div class="container">
		<div class="v-intro">
			<div class="left">
				<video id="videoPlayer" src="${video.videoUrl}" class="video-js vjs-default-skin" controls width="627" height="280"
					   poster="${video.videoImageUrl}" data-setup="{}">
				</video>
			</div>

			<div class="right">
				<p class="right-title">${video.videoTitle}</p>
				<div class="avatar">
					<span style="background-image: url(${video.speaker.speakerHeadUrl})"></span>
					<p><b>讲师：${video.speaker.speakerName}</b><br><i>${video.speaker.speakerDescr}</i></p>
				</div>
				<p class="video-intro">
					<span>本节内容：</span> ${video.videoDescr}
				</p>
			</div>
		</div>

		<div class="kcjs">
			<p class="title">课程介绍</p>
			<p class="content">${video.course.courseDescr}</p>
		</div>

	</div>
</div>
<!--目录-->
<div class="catalog">
	<div class="container">
		<p class="title">目录</p>

		<c:forEach items="${video.course.videoSet}" var="video" >
			<div class="chapter">
				<p class="biaoti"><a href="<c:url value="/front/video/index.action"/>?videoId=${video.id}&subjectId=${video.course.subject.id}">${video.videoTitle}</a></p>
				<p class="lecturer">${video.videoDescr}</p>
				<p class="lecturer">讲师：${video.speaker.speakerName}</p>
				<div class="v-info">
					<span class="count"><img src="<c:url value="/static/img/count.png"/>" alt="">${video.videoPlayTimes}</span>
					<span class="duration"><img src="<c:url value="/static/img/player.png"/>" alt="">${video.videoTimeLength}</span>
				</div>
			</div>
		</c:forEach>


	</div>
</div>