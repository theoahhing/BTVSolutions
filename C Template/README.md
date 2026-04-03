# C/C++ Portfolio Project Ideas

## 1. Custom Memory Allocator

### Overview
Build a custom dynamic memory allocator in C or C++ that mimics the behaviour of standard memory management functions such as `malloc`, `free`, and `calloc`. The goal of this project is to demonstrate a strong understanding of low-level memory management, heap organisation, pointer arithmetic, fragmentation, and performance trade-offs.

### Why This Project Matters
This project shows employers that I understand how memory is managed under the hood rather than only relying on the standard library. It highlights systems-level thinking, debugging ability, and performance awareness, which are highly relevant to embedded systems, backend infrastructure, game engines, and operating-system-adjacent development.

### Core Features
- Implement custom versions of:
  - `malloc`
  - `free`
  - `calloc`
  - `realloc` (optional but recommended)
- Manage heap blocks manually
- Track used and free memory regions
- Support splitting and coalescing memory blocks
- Handle alignment requirements
- Detect invalid frees and double frees
- Expose allocator statistics such as:
  - total allocated memory
  - free memory
  - number of allocations
  - fragmentation level

### Advanced Features
- Free list implementation
- Multiple allocation strategies:
  - first fit
  - best fit
  - worst fit
- Memory pooling for small fixed-size allocations
- Leak detection
- Allocation tracing/logging
- Guard bytes/corruption detection
- Benchmark against the standard allocator

### Suggested Architecture
- `Allocator` core
- `MemoryBlock` metadata structure
- `FreeListManager`
- `AllocatorStats`
- `AllocatorDebugger`

### Skills Demonstrated
- Pointer arithmetic
- Memory layout design
- Low-level debugging
- Data structure design
- Performance optimisation
- Defensive programming

### Stretch Goal
Create a visual heap debugger that prints the allocator state after each allocation/free call.

---

## 2. Thread Pool + Job System

### Overview
Build a multithreaded job system in C++ that manages a pool of worker threads and executes submitted tasks asynchronously. The project should focus on synchronization, task scheduling, thread-safe queues, and clean shutdown handling.

### Why This Project Matters
This project demonstrates strong knowledge of concurrency, synchronization primitives, and backend architecture. It also shows that I can design systems that scale beyond single-threaded execution, which is highly valuable in backend engineering, embedded software, simulation systems, and performance-critical applications.

### Core Features
- Create a fixed-size thread pool
- Submit tasks/jobs to the pool
- Store pending tasks in a thread-safe queue
- Worker threads wait for and execute tasks
- Graceful thread pool shutdown
- Handle exceptions thrown by worker tasks
- Support returning results from tasks

### Advanced Features
- Job priorities
- Delayed/scheduled jobs
- Work stealing
- Task cancellation
- Dependency-based job execution
- Thread naming and diagnostics
- Performance counters
- Configurable worker count
- Future/promise integration

### Suggested Architecture
- `ThreadPool`
- `WorkerThread`
- `TaskQueue`
- `Job`
- `Scheduler`
- `ThreadSafeLogger`

### Example Use Cases
- Background file processing
- Parallel data transformations
- Async server request handling
- Task scheduling engine
- Simulation/event processing

### Skills Demonstrated
- Multithreading
- Mutexes and condition variables
- Thread-safe data structures
- System design
- Race condition prevention
- Graceful shutdown and lifecycle management

### Stretch Goal
Use the thread pool in another project such as an HTTP server, file indexer, or simulation engine.

---

## 4. Roguelike Game (Terminal-Based or Minimal Graphics)

### Overview
Build a roguelike game in C++ that runs in the terminal or with a lightweight rendering library. The game should include procedural dungeon generation, player movement, combat, enemies, inventory, and turn-based gameplay. The goal is to create a technically strong and fun project that demonstrates architecture, game-loop design, and systems thinking.

### Why This Project Matters
A roguelike is a great portfolio project because it combines multiple software engineering concepts into one cohesive system. It demonstrates state management, pathfinding, procedural generation, object-oriented design, algorithms, and clean modular architecture. It also shows that I can build something substantial and interactive from scratch.

### Core Features
- Grid-based map system
- Procedurally generated dungeon/rooms
- Player movement
- Walls, floors, doors, and obstacles
- Enemy spawning and movement
- Turn-based combat
- Health and damage system
- Basic inventory
- Game loop with win/lose state
- Save/load system (optional)

### Advanced Features
- Fog of war
- Field of view calculation
- Item rarity and loot tables
- Multiple dungeon levels
- Enemy AI/pathfinding
- Status effects
- Equipment system
- NPC interactions
- Procedural item generation
- Replay log/debug mode

### Suggested Architecture
- `Game`
- `GameLoop`
- `Map`
- `DungeonGenerator`
- `Entity`
- `Player`
- `Enemy`
- `CombatSystem`
- `InventorySystem`
- `Renderer`
- `InputHandler`

### Technical Concepts Demonstrated
- State machines
- Game loop architecture
- Collision and movement logic
- Procedural generation
- Object-oriented design
- Algorithmic problem solving
- Data-driven design
- Separation of logic from rendering

### Skills Demonstrated
- C++ architecture and modularity
- Clean code organisation
- Systems thinking
- Interactive program design
- Debugging and iterative development

### Stretch Goal
Add a developer/debug console for spawning enemies, generating maps, or inspecting internal game state.
