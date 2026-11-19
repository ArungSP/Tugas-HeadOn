class GradeCalculator {
    private static final double BOBOT_TUGAS = 0.3;
    private static final double BOBOT_UTS = 0.3;
    private static final double BOBOT_UAS = 0.4;

    public double hitungNilaiAkhir(
            double nilaiTugas,
            double nilaiUts,
            double nilaiUas
    ) {
        return (nilaiTugas * BOBOT_TUGAS)
                + (nilaiUts * BOBOT_UTS)
                + (nilaiUas * BOBOT_UAS);
    }
}

interface ReportPrinter {
    void cetakLaporan(String nama, double nilai);
}

class ConsoleReportPrinter implements ReportPrinter {
    @Override
    public void cetakLaporan(String nama, double nilai) {
        System.out.println("Laporan Nilai Mahasiswa: " + nama + " = " + nilai);
    }
}

interface GradeRepository {
    void simpan(String nama, double nilai);
}

class DatabaseGradeRepository implements GradeRepository {
    @Override
    public void simpan(String nama, double nilai) {
        System.out.println("Menyimpan ke database: " + nama + " = " + nilai);
    }
}

class StudentGradingService {
    private final GradeCalculator calculator;
    private final ReportPrinter printer;
    private final GradeRepository repository;

    public StudentGradingService(
            GradeCalculator calculator,
            ReportPrinter printer,
            GradeRepository repository
    ) {
        this.calculator = calculator;
        this.printer = printer;
        this.repository = repository;
    }

    public void proses(
            String nama,
            double nilaiTugas,
            double nilaiUts,
            double nilaiUas
    ) {
        double nilaiAkhir = calculator.hitungNilaiAkhir(
                nilaiTugas,
                nilaiUts,
                nilaiUas
        );

        printer.cetakLaporan(nama, nilaiAkhir);
        repository.simpan(nama, nilaiAkhir);
    }
}

public class Latihan2 {
    public static void main(String[] args) {
        StudentGradingService service = new StudentGradingService(
                new GradeCalculator(),
                new ConsoleReportPrinter(),
                new DatabaseGradeRepository()
        );

        service.proses("Andi", 80, 85, 90);
    }
}