package com.tikitaka.cloudFunding.community.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tikitaka.cloudFunding.community.model.service.CommunityService;
import com.tikitaka.cloudFunding.community.model.vo.PostVo;
import com.tikitaka.cloudFunding.project.model.service.ProjectService;
import com.tikitaka.cloudFunding.project.model.vo.ProjectVo;

@Controller
public class CommunityController {
	@Autowired
	CommunityService cService;
	@Autowired
	ProjectService projectService;
	
	@RequestMapping("projectCommunity.do")
	public ModelAndView projectCommunity(int projectCode, ModelAndView mv){
		// 해당 프로젝트의 게시글/댓글 조회해서 넘겨주기
		ProjectVo project = projectService.selectProjectDetail(projectCode);
		List<PostVo> postList = cService.selectPostList(project.getProjectCode());
		int count = cService.selectPostCount(projectCode);
		mv.addObject("count", count);
		mv.addObject("project", project);
		mv.addObject("postList", postList);
		mv.setViewName("project/detail/community");
		return mv;
	}
	
	@RequestMapping("insertPost.do")
	public ModelAndView insertPost(PostVo post, ModelAndView mv){
		
		
		return mv;
	}
	
	
}
