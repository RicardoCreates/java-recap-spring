package de.ricardo.javarecapspring;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class KanbanController {

    public final KanbanService kanbanService;

    @GetMapping
    public List<Kanban> getKanbans(){
        return  kanbanService.getKanbans();
    }

    @GetMapping("/{id}")
    public Kanban getKanbanById(@PathVariable String id) {
        return kanbanService.getKanbanById(id);
    }

    @PostMapping
    public Kanban createKanban(@RequestBody Kanban kanban){
        return kanbanService.createKanban(kanban);
    }

    @PutMapping("/{id}")
    public Kanban updateKanban(@RequestBody Kanban kanban, @PathVariable String id){
        return kanbanService.updateKanban(kanban, id);
    }

    @DeleteMapping("/{id}")
    public void deleteKanban(@PathVariable String id){
        kanbanService.deleteKanban(id);
    }

}
