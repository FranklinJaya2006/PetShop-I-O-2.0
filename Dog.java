public abstract class Dog {
    private String ukuran;
    private Boolean makanberapa;
    private String nama;
    private String sedangapa;
    private String jenis;

    public Dog() {
    }

    public Dog(String jenis, String ukuran, String sedangapa, String nama, Boolean makanberapa) {
        int makanBerapa;
        switch(ukuran){
            case "Small":
                makanBerapa = 1;
                break;
            case "Medium":
                makanBerapa = 2;
                break;
            case "Large":
                makanBerapa = 3;
                break;
            default:
                makanBerapa = 0;
        }
        this.ukuran = ukuran;
        this.makanberapa = makanberapa;
        this.nama = nama;
        this.sedangapa = sedangapa;
    }

    public Dog(String jenis, String nama, String ukuran, Boolean makanberapa, String sedangapa) {
		//TODO Auto-generated constructor stub
	}

    public String getJenis() {
        return this.jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

	public String getUkuran() {
        return this.ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public Boolean getmakanBerapa() {
        return this.makanberapa;
    }

    public void setmakanBerapa(Boolean makanberapa) {
        this.makanberapa = makanberapa;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getSedangapa() {
        return this.sedangapa;
    }

    public void setSedangapa(String sedangapa) {
        this.sedangapa = sedangapa;
    }

}