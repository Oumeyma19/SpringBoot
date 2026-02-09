package tn.esprit.ds.championnat.services;

import tn.esprit.ds.championnat.entites.Sponsor;
import tn.esprit.ds.championnat.repositories.SponsorRepository;

import java.util.List;

public class SponsorService implements ISponsorService{

    private SponsorRepository sponsorRepository;


    @Override
    public Sponsor ajouterSponsor(Sponsor sponsor) {
        // Initialisation automatique des champs demandés
        sponsor.setDateCreation(java.time.LocalDate.now()); // Date système
        sponsor.setArchived(false); // Initialisé à false
        sponsor.setBloquerContrat(false); // Initialisé à false

        return sponsorRepository.save(sponsor);

    }

    @Override
    public List<Sponsor> ajouterSponsors(List<Sponsor> sponsors) {
        // On boucle sur la liste pour initialiser chaque sponsor
        for (Sponsor s : sponsors) {
            s.setDateCreation(java.time.LocalDate.now());
            s.setArchived(false);
            s.setBloquerContrat(false);
        }
        // On sauvegarde toute la liste d'un coup
        return (List<Sponsor>) sponsorRepository.saveAll(sponsors);
    }

    @Override
    public Sponsor modifierSponsor(Sponsor sponsor) {
        // La dateDerniereModification doit être la date système
        sponsor.setDateDerniereModification(java.time.LocalDate.now());
        return sponsorRepository.save(sponsor);
    }

    @Override
    public void supprimerSponsor(Long idSponsor) {
        sponsorRepository.deleteById(idSponsor);
    }

    @Override
    public List<Sponsor> listSponsors() {
        return (List<Sponsor>) sponsorRepository.findAll();
    }

    @Override
    public Sponsor recupererSponsor(Long idSponsor) {
        // .orElse(null) permet d'éviter les erreurs si l'ID n'existe pas
        return sponsorRepository.findById(idSponsor).orElse(null);
    }

    @Override
    public Boolean archiverSponsor(Long idSponsor) {
        // 1. On récupère le sponsor par son ID
        Sponsor sponsor = sponsorRepository.findById(idSponsor).orElse(null);

        if (sponsor != null) {
            // 2. Mettre archived à true
            sponsor.setArchived(true);
            // 3. On enregistre la modification
            sponsorRepository.save(sponsor);
            return true;
        }
        return false;
    }
}
