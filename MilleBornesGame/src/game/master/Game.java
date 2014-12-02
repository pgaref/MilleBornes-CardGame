/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.master;

// TODO: Auto-generated Javadoc
/**
 * This interface describes a generic set of supported operations
 * that can be found in every game such as start/stop/pause etc.
 *
 * @author Author
 */
public interface Game {
    
    /**
     * Start.
     */
    public void Start();
    
    /**
     * Stop.
     */
    public void Stop();
    
    /**
     * Pause.
     */
    public void Pause();
    
    /**
     * Resume.
     */
    public void Resume();
    
    /**
     * Restart.
     */
    public void Restart();
}