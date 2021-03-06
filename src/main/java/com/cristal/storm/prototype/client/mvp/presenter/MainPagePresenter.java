/**
 * Copyright 2010 ArcBees Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.cristal.storm.prototype.client.mvp.presenter;

import com.cristal.storm.prototype.client.mvp.view.MainPageUiHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;

import com.gwtplatform.dispatch.client.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealRootLayoutContentEvent;

/**
 * @author Jos� Rose
 */

public class MainPagePresenter
		extends
		Presenter<MainPagePresenter.MainPageViewInterface, MainPagePresenter.MainPageProxy>
		implements MainPageUiHandlers {

	// /////////////////////////////////////////////////////////////////////////
	// Members
	// /////////////////////////////////////////////////////////////////////////
	public static final String nameToken = "main";

	private final PlaceManager placeManager;

	private final DispatchAsync dispatcher;

	// /////////////////////////////////////////////////////////////////////////
	// Interfaces
	// /////////////////////////////////////////////////////////////////////////

	/**
	 * {@link MainPagePresenter}'s proxy.
	 */
	@ProxyStandard
	@NameToken(nameToken)
	public interface MainPageProxy extends Proxy<MainPagePresenter>, Place {
	}

	/**
	 * {@link MainPagePresenter}'s view. Here it extends HasUiHandlers to be
	 * able to call setUiHandlers.
	 */
	public interface MainPageViewInterface extends View,
			HasUiHandlers<MainPageUiHandlers> {
		public String getUriText();

		public String getTagsText();

		public void addToMCECollection(String uriText, String tagsText);

		public void tagCollectionFilter(String filter);
	}
	
    ///////////////////////////////////////////////////////////////////////////
    // Constructors
    ///////////////////////////////////////////////////////////////////////////
    @Inject
    public MainPagePresenter(final EventBus eventBus,
            final MainPageViewInterface view,
            final MainPageProxy proxy, final PlaceManager placeManager,
            final DispatchAsync dispatcher) {
        super(eventBus, view, proxy);
        getView().setUiHandlers(this);

        this.placeManager = placeManager;
        this.dispatcher = dispatcher;
        
    }
    
    ///////////////////////////////////////////////////////////////////////////
    // Handlers
    ///////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////
    // Overrides
    ///////////////////////////////////////////////////////////////////////////
	@Override
	protected void onBind() {
		super.onBind();
	}

    @Override
    protected void revealInParent() {
        RevealRootLayoutContentEvent.fire(this, this);
    }

    @Override
    public void onStormit() {
        getView().addToMCECollection(getView().getUriText(),getView().getTagsText());
    }

    ///////////////////////////////////////////////////////////////////////////
    // Functions
    ///////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////
    // Getters / Setters
    ///////////////////////////////////////////////////////////////////////////

}
