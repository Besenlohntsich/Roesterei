import nrw.*;

public class Benutzerverwaltung {
    private BinarySearchTree<Benutzerprofil> benutzerBaum;

    public Benutzerverwaltung() {
        benutzerBaum = new BinarySearchTree<>();
    }

    public void neuenBenutzerAnlegen() {
        Benutzerprofil neuerBenutzer = new Benutzerprofil(pBenutzername, pPw);
        benutzerBaum.insert(neuerBenutzer);
    }

    public void nutzerLoeschen(String pBenutzername, String pPw) {
        Benutzerprofil zuLoeschenderBenutzer = new Benutzerprofil(pBenutzername, pPw);
        benutzerBaum.remove(zuLoeschenderBenutzer);
    }

    public boolean profilVorhanden(String pBenutzername) {
        Benutzerprofil suchProfil = new Benutzerprofil(pBenutzername, "");
        return benutzerBaum.search(suchProfil) != null;
    }

}