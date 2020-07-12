package lab.phb.amaliyahgian.controller;
import lab.phb.amaliyahgian.entity.DataMahasiswa;
import lab.phb.amaliyahgian.model.DataMahasiswaModel;
import lab.phb.amaliyahgian.services.DataMahasiswaServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import  java.util.Optional;

@Controller //agar spring mengerti bagaimana mengarahkan file mana yang perlu ditampilkan ke browser
public class WebController {

    @Autowired
    private DataMahasiswaServices service;

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("data", service.getAllData());
        return "index";
    }

    @GetMapping("/tambah")
    public String tampilkanTambahForm(Model model) {
        model.addAttribute("data", new DataMahasiswaModel());
        return "tambah-data";
    }

    @PostMapping("/simpan")
    public String simpan(DataMahasiswaModel data) {
        service.save(service.convertToEntity(data));
        return "redirect:/";
    }

    @GetMapping("/ubah/{nim}")
    public String ubah(@PathVariable("nim") String nim, Model model) {
        Optional<DataMahasiswa> result = service.findById(nim);
        if(result.isPresent()) {
            DataMahasiswa data1 = result.get();
            model.addAttribute("data", data1);
            return "edit-data";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/hapus/{nim}")
    public String hapus(@PathVariable("nim") String nim) {
        service.removeById(nim);
        return "redirect:/";
    }


}
