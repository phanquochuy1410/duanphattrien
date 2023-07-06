package com.example.demo.controller;

import com.example.demo.entity.ChiTietAo;
import com.example.demo.entity.HoaDon;
import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.entity.KhachHang;
import com.example.demo.repository.ChiTietAoRepository;
import com.example.demo.repository.HoaDonChiTietRepository;
import com.example.demo.repository.HoaDonRepository;
import com.example.demo.service.BanHangService;
import com.example.demo.service.ChiTietAoService;
import com.example.demo.service.HoaDonChiTietService;
import com.example.demo.service.HoaDonService;
import com.example.demo.service.KhachHangService;
import com.example.demo.service.NhanVienService;
import com.example.demo.service.impl.BanHangServiceImpl;
import com.example.demo.service.impl.ChiTietAoServiceImpl;
import com.example.demo.service.impl.HoaDonChiTietServiceImpl;
import com.example.demo.service.impl.HoaDonServiceImpl;
import com.example.demo.service.impl.KhachHangServiceImpl;
import com.example.demo.service.impl.NhanVienServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class BanHangController {

    @Autowired
    private ChiTietAoRepository repository;

    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;

    @Autowired
    private ChiTietAoService chiTietAoService = new ChiTietAoServiceImpl();

    @Autowired
    private HoaDonService hoaDonService = new HoaDonServiceImpl();

    @Autowired
    private HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietServiceImpl();

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private KhachHangService khachHangService = new KhachHangServiceImpl();

    @Autowired
    private BanHangService banHangService = new BanHangServiceImpl();

    @Autowired
    private NhanVienService nhanVienService = new NhanVienServiceImpl();

    private  UUID idChiTietAo ;

    private List<ChiTietAo> chiTietAoList = new ArrayList<>();


    @GetMapping("/trang-chu")
    public String hienThi(Model model, @RequestParam(defaultValue = "0") int page) {

        int soTrang = 8;
        Page<ChiTietAo> phanTrang = repository.findAll(PageRequest.of(page, soTrang));
        int cuoiTrang = phanTrang.getTotalPages();

        model.addAttribute("listChiTietAo", phanTrang.getContent());
        model.addAttribute("soTrang", page);
        model.addAttribute("cuoiTrang", cuoiTrang);

        model.addAttribute("view", "ban-hang/ban-hang.jsp");
        return "layout";
    }

    @GetMapping("/trang-chu/detail/{idChiTiet}")
    public String detailChiTiet(Model model, @PathVariable("idChiTiet") UUID id) {
        idChiTietAo = id;
        model.addAttribute("hoaDon", hoaDonService.fillHoaDon(1));
        model.addAttribute("listChiTietAo" , chiTietAoService.getAll());
        model.addAttribute("ct", chiTietAoService.getOne(id));
        model.addAttribute("view", "ban-hang/xem-thong-tin.jsp");
        return "layout";
    }

    @PostMapping("/add-san-pham")
    public String addSanPham(@Valid @ModelAttribute HoaDonChiTiet hoaDonChiTiet, @Valid @ModelAttribute HoaDon hoaDon , @Valid @ModelAttribute ChiTietAo chiTietAo , Model model) {
        if (!hoaDonChiTietService.checkIdSanPham(hoaDonChiTiet.getIdChiTietAo().getId() , hoaDonChiTiet.getIdHoaDon().getId())){
            model.addAttribute("ct" , chiTietAoService.getOne(idChiTietAo));
            model.addAttribute("hoaDon", hoaDonService.fillHoaDon(1));
            model.addAttribute("message" , "Sản phẩm đã tồn tại trong giỏ hàng !");
            model.addAttribute("view", "ban-hang/xem-thong-tin.jsp");
            return "layout";
        }
//        hoaDonService.updateHoaDons(hoaDon.getId() , 2);
        hoaDonChiTietService.addHoaDonChiTiet(hoaDonChiTiet);
        return "redirect:/gio-hang";
    }

    @PostMapping("/update-san-pham")
    public String updateSanPham(@Valid @ModelAttribute HoaDonChiTiet hoaDonChiTiet) {
        hoaDonChiTietService.updateHoaDonChiTiet(hoaDonChiTiet, hoaDonChiTiet.getId());
        return "redirect:/gio-hang";
    }

    @GetMapping("/gio-hang")
    public String gioHang(Model model) {

        model.addAttribute("listKhachHang", khachHangService.getAll());
        model.addAttribute("listNhanVien", nhanVienService.getAll());
        model.addAttribute("hoaDon", hoaDonService.fillHoaDon(1));
        model.addAttribute("listHDCT", hoaDonChiTietService.getAll());
        model.addAttribute("view", "ban-hang/gio-hang.jsp");
        return "layout";
    }

    @GetMapping("/delete/{idSanPham}")
    public String deleteSanPham(@PathVariable("idSanPham") UUID id) {
        HoaDonChiTiet hoaDonChiTiets = hoaDonChiTietRepository.findById(id).get();
        hoaDonChiTietService.deleteSanPham(hoaDonChiTiets);
        return "redirect:/gio-hang";
    }

    @GetMapping("/hoa-don")
    public String hoaDon(Model model) {
        model.addAttribute("listHD", hoaDonService.getAll());
        model.addAttribute("view", "ban-hang/hoa-don.jsp");
        return "layout";
    }

    @PostMapping("/hoa-don/add")
    public String addHoaDon(@Valid @ModelAttribute HoaDon hoaDon) {
        hoaDonService.addHoaDon(hoaDon);
        return "redirect:/hoa-don";
    }

    @GetMapping("/trang-chu/search")
    public String searchAo(@RequestParam("searchAo") String tenAo, Model model) {
        model.addAttribute("listChiTietAo", chiTietAoService.searchAo(tenAo));
        model.addAttribute("view", "ban-hang/ban-hang.jsp");
        return "layout";
    }

    @GetMapping("/khach-hang/detail/{idKhachHang}")
    public String detailKhachHang(Model model , @PathVariable("idKhachHang") UUID id){
        model.addAttribute("kh",khachHangService.getOne(id));
        return "redirect:/gio-hang";
    }

    @GetMapping("/hoa-don/delete/{idHoaDon}")
    public String deleteHoaDon(@PathVariable("idHoaDon") UUID id){
        HoaDon hoaDon = hoaDonRepository.getReferenceById(id);
        hoaDonService.deleteHoaDon(hoaDon);
        return "redirect:/hoa-don";
    }

    @PostMapping("/addKhachHang")
    public String addKhachHang(@Valid @ModelAttribute KhachHang khachHang , Model model){
        khachHangService.addKhachHang(khachHang);
        return "redirect:/gio-hang";
    }

    @PostMapping("/thanh-toan")
    public String thanhToan(HoaDonChiTiet hoaDonChiTiet , HoaDon hoaDon , Model model){
        model.addAttribute("hd" , hoaDonService.getAll());
        hoaDonChiTietService.deleteHoaDon(hoaDonChiTiet);
        hoaDonService.updateHoaDon(hoaDon , hoaDon.getId());
        return "redirect:/trang-chu";
    }

    @GetMapping("/gio-hang/hien-thi")
    public String loadTable(@RequestParam("idHoaDon") UUID id, Model model , HoaDon hoaDon){
        HoaDon hoaDons = hoaDonRepository.findHoaDonById(id);
        model.addAttribute("tongTien",hoaDonChiTietRepository.tongTien(hoaDons.getId()));
        model.addAttribute("listKhachHang", khachHangService.getAll());
        model.addAttribute("listNhanVien", nhanVienService.getAll());
        model.addAttribute("hoaDon", hoaDonService.fillHoaDon(1));
        List<HoaDonChiTiet> hoaDonChiTiets = hoaDonChiTietService.loadTable(id);
        model.addAttribute("listHDCT" , hoaDonChiTiets);
        model.addAttribute("view","ban-hang/gio-hang.jsp");
        return "layout";
    }
}
