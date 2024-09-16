package de.ricardo.javarecapspring;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KanbanService {

    private final KanbanRepo kanbanRepo;
    private final idService idService;

    public List<Kanban> getKanbans(){
        List<Kanban> kanbans = kanbanRepo.findAll();
        return kanbans;
    }

    public Kanban getKanbanById(String id){
        return kanbanRepo.findById(id).orElse(null);
    }

    public Kanban createKanban(Kanban kanban){
        Kanban kanbanToAdd = new Kanban(
                idService.generateId(),
                kanban.description(),
                kanban.status()
        );
        return kanbanRepo.save(kanbanToAdd);
    }

    public Kanban updateKanban(Kanban kanban, String id){
        if (kanbanRepo.existsById(id)){
            kanbanRepo.deleteById(id);
            Kanban kanbanUpdate = new Kanban(
                    idService.generateId(),
                    kanban.description(),
                    kanban.status()
            );
            return kanbanRepo.save(kanbanUpdate);
        }
        return null;
    }

    public void deleteKanban(String id){
        kanbanRepo.deleteById(id);
    }

}
