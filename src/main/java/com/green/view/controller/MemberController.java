package com.green.view.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.green.biz.dto.MemberVO;
import com.green.biz.member.MemberService;

@Controller
@SessionAttributes("loginUser")
public class MemberController {

	
	@Autowired
	private MemberService memberService;
	
	//������Ʈ �� �ҷ�����
	@RequestMapping(value="/profile_update_form",method=RequestMethod.GET)
	public String profileUpdate(MemberVO vo,Model model,HttpSession session) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");

		if(loginUser==null) {
			System.out.println("������Ʈ �� �ҷ����� ����");
			return "member/login";
		}else {
		
			//�α����� ������ ������ ��������
			vo.setEmail_id(loginUser.getEmail_id());
		MemberVO myprofile = memberService.memberInfo(vo);
		
		model.addAttribute("myprofile", myprofile);
		
		return "profile/profile_edit";
		}
	}
	
	
	//���� ���� ������Ʈ
	@RequestMapping(value="profile_member_update",method=RequestMethod.POST)
	public String memberUpdate(@RequestParam(value="profile_upload") MultipartFile uploadFile,
			@RequestParam(value="no_update_img") String old_profile_img,
			MemberVO vo, HttpSession session) {
		String url = "";

		MemberVO loginUser = memberService.memberInfo(vo);
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

		HttpServletRequest objRequest = requestAttributes.getRequest();

		HttpSession mobjSession = objRequest.getSession();

		mobjSession.setAttribute("loginUser",loginUser);
		
	
		
		if (loginUser == null) {
			url = "login/login_form";
			System.out.println("Ż��");
		} else {
		
			
			String imgFile = "";
			
			if(!uploadFile.isEmpty()) {//ȭ�鿡�� �̹����� ���� ���
				imgFile = uploadFile.getOriginalFilename();
				vo.setProfile_img(imgFile);//�̹����� memeberVO�� ����
				
				//���� �̵���� ���ϱ�
				String image_path
				=session.getServletContext().getRealPath("WEB-INF/resources/images/");
				System.out.println("�̵� �̹��� ���: " +image_path );
				
				try {
					File file = new File(image_path+imgFile);
					uploadFile.transferTo(file);//�̹��� ���� ��η� �̵�
				}catch(IllegalStateException | IOException e) {
					e.printStackTrace();
				}

			} else {
				vo.setProfile_img(old_profile_img);
			}
			memberService.updateMember(vo);
			
			url = "redirect:profile_edit?Email_id="+vo.getEmail_id();
		}
		
		System.out.println();
		return url;
		
	}
	
	//����� ���� ��Ȯ��
	@RequestMapping(value="profile_edit")
	public String profileDetail(MemberVO vo,HttpSession session,Model model) {
		
		MemberVO loginUser = memberService.memberInfo(vo);
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

		HttpServletRequest objRequest = requestAttributes.getRequest();

		HttpSession mobjSession = objRequest.getSession();

		mobjSession.setAttribute("loginUser",loginUser);
		
		MemberVO myprofile = memberService.memberInfo(vo);
		
		model.addAttribute("myprofile", myprofile);
		
		return "profile/profile_edit";
	}

	@RequestMapping(value="/address_edit", method=RequestMethod.GET)
	public String addressEditView() {
		
		return "profile/address_edit";
	}

	
	/*
	 *  �α��� ȭ�� ǥ��
	 */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginView() {
		
		return "member/login";
	}

	/*
	 *	����� �α��� ó��
	 *  
	 *  
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginAction(MemberVO vo, Model model) {
		MemberVO loginUser = null;
		int result = memberService.loginID(vo);
		
		if (result == 1) { // ����� ���� ����
			loginUser = memberService.getMember(vo.getEmail_id());
			
			model.addAttribute("loginUser", loginUser);

			return "redirect:/index";
		} else  {
			return "member/login_fail";
		}
	}
		
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(SessionStatus status) {
		
		status.setComplete();  // ���� ������ ����
		
		return "member/login";
		
	}




		/*
		 * ȸ������
		 */
		
		@RequestMapping(value="/join", method=RequestMethod.GET)
		public String joinView() {
			
			return "member/join";
		}
		/*
		 *  �̸��� �ߺ�üũ ȭ�����
		 */
		
		@RequestMapping(value="/id_check_form" , method=RequestMethod.GET)
		public String idCheckView(@RequestParam(value="email_id", defaultValue="", required=true)
									String email_id, Model model) {
			
			/*
			 *  �̸��� �ߺ�Ȯ�� ��ûó��
			 */
			
			model.addAttribute("email_id", email_id);
			return "member/idcheck";
		}
		/*
		 * ����� �̸��� �ߺ�üũ
		 */
		@RequestMapping(value="/id_check_form" , method=RequestMethod.POST)
		public String idCheckAction(@RequestParam(value="email_id", defaultValue="", required=true)
							String  email_id, Model model) {
				
			MemberVO loginUser = memberService.getMember(email_id);
				
				if(loginUser != null) {
					model.addAttribute("message", 1);
				}else {
					model.addAttribute("message", -1);
				}
				
				model.addAttribute("email_id", email_id);
				
				return "member/idcheck";
		
		
		}
		
		@RequestMapping(value="id_check_confirmed", method=RequestMethod.GET)
		public String idCheckConfirmed(MemberVO vo, Model model) {
			
			model.addAttribute("email_id", vo.getEmail_id());
			model.addAttribute("reid", vo.getEmail_id());
			return "member/join";
	}
		
		@RequestMapping(value="address_confirmed", method=RequestMethod.POST)
		public String addressConfirmed(@RequestParam(value="addr1", required=false) String addr1,
				@RequestParam(value="addr2", required=false) String addr2,
				@RequestParam(value="addr3", required=false) String addr3,
				@RequestParam(value="emailID") String email_id,
				MemberVO vo) {


					vo.setEmail_id(email_id);
					vo.setAddress(addr1 + " " + addr2 +" "+ addr3);
					memberService.updateAddress(vo);
					
					return "member/close2";
					}
		
		
		@RequestMapping(value="join", method=RequestMethod.POST)
		public String joinAction(@RequestParam(value="addr1", required=false) String addr1,
									@RequestParam(value="addr2", required=false) String addr2,
									@RequestParam(value="addr3", required=false) String addr3,
									
									MemberVO vo) {
			
			
			vo.setAddress(addr1 + " " + addr2 +" "+ addr3);
			memberService.insertMember(vo);
			
			
			return "member/login";
		}
		
		
		
		
		
		/*
		 * ���̵�/��� ã�� ��ûó��
		 */

		@RequestMapping(value="/find_id_form", method=RequestMethod.GET)
		public String findIdView() {
			
			return "member/findIdAndPassword";
		}

		@RequestMapping(value="/find_id", method=RequestMethod.GET)
		public String findIdAction(MemberVO vo, Model model) {
			
			MemberVO member = memberService.getMemberByNameAndPhnm(vo);
		
			if (member != null) {  // ���̵� �����ϴ� ���
				model.addAttribute("message", 1);
				model.addAttribute("email_id", member.getEmail_id());
			} else { 
				model.addAttribute("message", -1);
			}  
			return "member/findResult";
		}
		
		
		/*
		@RequestMapping(value="/findpw", method=RequestMethod.GET)
		public String findpw() {
			
			return "member/findpw";
		}
		*/
		
		
		/*����*/
		@RequestMapping(value="/find_password", method=RequestMethod.GET)
		public String findPassword(MemberVO vo, Model model) {
			
			MemberVO member = memberService.findPassword(vo);
			
			if (member != null) {  // ���̵� �����ϴ� ���
				model.addAttribute("message", 1);
				model.addAttribute("email_id", member.getEmail_id());
			} else {
				model.addAttribute("message", -1);
			}
			
			
			return "member/findPwdResult";
		}
		
		@RequestMapping(value="/change_password", method=RequestMethod.POST)
		public String changePassword(MemberVO vo, Model model) {
			
			memberService.changePassword(vo);
			
			return "member/close";
		}
	
}
		
		
		
		
		
		
		
		/* NEW ��й�ȣ ã�� */
		/*
		@RequestMapping(value = "/find_pw", method = RequestMethod.GET)
		public void findPwGET() throws Exception{
		}

		@RequestMapping(value = "/find_pw", method = RequestMethod.POST)
		public void findPwPOST(@ModelAttribute MemberVO member, HttpServletResponse response) throws Exception{
			memberService.findPw(response, member);
		}
		
	}
		*/
		


