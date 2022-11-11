package com.bitcamp.gabojago.web;

import com.bitcamp.gabojago.service.ExhibitionReviewService;
import com.bitcamp.gabojago.service.ExhibitionService;
import com.bitcamp.gabojago.vo.Exhibition;
import com.bitcamp.gabojago.vo.ExhibitionFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller // 주소 전달
@RequestMapping("/exhibition/")
public class ExhibitionController {

 /* ServletContext sc;*/
  @Autowired
  ExhibitionService exhibitionService;

  @Autowired
  ExhibitionReviewService exhibitionReviewService;

  @Autowired
  ServletContext servletContext; // 테스트 필요



// 파일
/* 멀티 사용
  private List<ExhibitionFile> saveExhibitionFiles(Part[] files)
      throws IOException,ServletException{
    List<ExhibitionFile> exhibitionFiles = new ArrayList<>();
    String path = servletContext.getRealPath("../board/files");

    System.out.println(path);

    for(Part part : files){
      if(part.getSize() == 0 ){
        continue;
      }
    String fname = UUID.randomUUID().toString();
      part.write(path + "/" + fname);
    }
    return exhibitionFiles;
  }
*/





  private List<ExhibitionFile> saveExhibitionFiles(MultipartFile[] files)
      throws IOException, ServletException {
    List<ExhibitionFile> exhibitionFiles = new ArrayList<>();

     String dirpath = servletContext.getRealPath("/board/files");
    System.out.println("호출:" + dirpath);
    for (MultipartFile file : files) {
      if (file.isEmpty()) {
        continue;
      }
      String path = UUID.randomUUID().toString();
      String fname = file.getOriginalFilename();
      file.transferTo(new File(dirpath + "/" + path));
      exhibitionFiles.add(new ExhibitionFile(path,fname));
    }


    return exhibitionFiles;
  }



/*
  @RequestMapping(value = "uploadTest", method = RequestMethod.POST)
  public void uploadTestPOST(MultipartFile[] files) {

    String dirpath = servletContext.getRealPath("/board/files");
    System.out.println("호출:" + dirpath);

    for (MultipartFile file : files) {
      if (file.isEmpty()) {
        continue;
      }

      String fname = file.getOriginalFilename();
      String path = UUID.randomUUID().toString();
     fname = path + "_" + fname;

     File saveFile = new File(path,fname);

      try {
        file.transferTo(saveFile);
        File thumbnailFile = new File(path, "s_" + fname) ;

        BufferedImage bo_image = ImageIO.read(saveFile);

        */
/* 비율 *//*

        double ratio = 3;
        int width = (int) (bo_image.getWidth() / ratio);
        int height = (int) (bo_image.getHeight() / ratio);

        // 생성자 매개변수 넓이, 높이, 생성될 이미지 타입
        BufferedImage bt_image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

        Graphics2D graphic = bt_image.createGraphics();

        graphic.drawImage(bo_image, 0, 0, width, height, null);

        ImageIO.write(bt_image, "jpg", thumbnailFile);
        */
/* ...................... *//*

      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
*/





  @PostMapping("add")
  public String insert(Exhibition exhibition,MultipartFile[] files,
                       HttpSession session) throws Exception {

    exhibition.setExhibitionFiles(saveExhibitionFiles(files));
/*
    board.setWriter((Member) session.getAttribute("loginMember"));
*/
    exhibitionService.insert(exhibition);
    return "redirect:exhibitionlist";
  }



  @GetMapping("exhibitionlist")
  public void list(Model model) throws Exception {
    model.addAttribute("exhibitions", exhibitionService.exhibitionList());
  }


  @GetMapping("detail")
  public void detail(int exno, Model model, HttpSession session) throws Exception {
    model.addAttribute("exhibition", exhibitionService.exhibitionSelect(exno));
    model.addAttribute("exhibitionReviews", exhibitionReviewService.exhibitionReviewList(exno));

  } // 강사님 보드는 map 사용

  @GetMapping("form")
  public void insert() throws Exception{
  }


/*private void checkOwner(int exno, HttpSession session) throws Exception{
  Member loginMember = (Member) session.getAttribute("loginMember");
  if (exhibitionService.get(exno).getWriter().getNo() != loginMember.getNo()) {
    throw new Exception("게시글 작성자가 아닙니다.");
  }
}  추후에 어드민 추가 */

@GetMapping("delete")
public String delete(int exno/* HttpSession session*/) throws Exception {
    //  checkOwner(no, session);
    if(!exhibitionService.delete(exno)) {
      throw new Exception("게시글을 삭제 할 수 없습니다.");
    }

    return "redirect:exhibitionlist";
}

  @GetMapping("updateform") // 수정창, 내용수정하고 서브밋 누르면
  public void update(int exno, Model model) throws Exception{
    model.addAttribute("exhibition", exhibitionService.exhibitionSelect(exno));

  }

@PostMapping("update") // 내용 저장됨
public String update(Exhibition exhibition, MultipartFile[] files, HttpSession session) throws Exception{
//  첨부파일 추가
  exhibition.setExhibitionFiles(saveExhibitionFiles(files));


// 어드민추가
//  checkOwner(board.getNo(), session);

  if(!exhibitionService.update(exhibition)){
    throw new Exception("게시글을 변경할 수 없습니다.");
  }
  return "redirect:exhibitionlist";
}


/*  private void checkOwner(int boardNo, HttpSession session) throws Exception {
    Member loginMember = (Member) session.getAttribute("loginMember");
    if (boardService.get(boardNo).getWriter().getNo() != loginMember.getNo()) {
      throw new Exception("게시글 작성자가 아닙니다.");
    }
  }*/




  @GetMapping("fileDelete")
  public String fileDelete(
      int exfno,
      HttpSession session)
      throws Exception {

    ExhibitionFile exhibitionFile = exhibitionService.getExhibitionFile(exfno);

    /*Member loginMember = (Member) session.getAttribute("loginMember");*/
    Exhibition exhibition = exhibitionService.get(exhibitionFile.getExno());

    /*if (board.getWriter().getNo() != loginMember.getNo()) {
      throw new Exception("게시글 작성자가 아닙니다.");
    }*/

    if (!exhibitionService.deleteExhibitionFile(exfno)) {
      throw new Exception("게시글 첨부파일을 삭제할 수 없습니다.");
    }

    return "redirect:detail?exno=" + exhibition.getExno();
  }









  @ResponseBody  //데이터 전달 빠르게 확인 가능 CRUD만
  @RequestMapping("select-list")
  public List<Exhibition> exhibitionList() throws Exception{
    return exhibitionService.exhibitionList();
  }

  @ResponseBody  //데이터 전달
  @RequestMapping("select/{exno}")
  public Exhibition exhibitionSelect(@PathVariable("exno") int exno) throws Exception{
    return exhibitionService.exhibitionSelect(exno);
  }



}
