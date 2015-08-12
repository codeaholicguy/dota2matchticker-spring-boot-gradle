/**
 *
 */
package com.codeaholicguy.dota2matchticker.controller;

import com.codeaholicguy.dota2matchticker.constant.Web;
import com.codeaholicguy.dota2matchticker.response.BaseResponse;
import com.codeaholicguy.dota2matchticker.response.MatchesResponse;
import com.codeaholicguy.dota2matchticker.service.MatchTickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hoangnn
 */
@Controller
@RequestMapping("/matches")
public class MatchTickerController {

    @Autowired
    private MatchTickerService matchTickerService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public
    String index() {
        return Web.Page.INDEX;
    }

    @RequestMapping(value = "/upcomming", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    Object getUpCommingMatches() {
        BaseResponse response;
        try {
            MatchesResponse matchesResponse = new MatchesResponse();
            matchesResponse.setData(matchTickerService.getUpCommingMatchs());
            matchesResponse.setResult(BaseResponse.SUCCESS);

            return matchesResponse;
        } catch (Exception e) {
            response = new BaseResponse(BaseResponse.FAIL, e.getMessage());
            return response;
        }
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    Object getRecentResultMatches() {
        BaseResponse response;

        try {
            MatchesResponse matchesResponse = new MatchesResponse();
            matchesResponse.setData(matchTickerService.getRecentResultMatchs());
            matchesResponse.setResult(BaseResponse.SUCCESS);

            return matchesResponse;
        } catch (Exception e) {
            response = new BaseResponse(BaseResponse.FAIL, e.getMessage());
            return response;
        }
    }

    @RequestMapping(value = "/live", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    Object getLiveMatches() {
        BaseResponse response;

        try {
            MatchesResponse matchesResponse = new MatchesResponse();
            matchesResponse.setData(matchTickerService.getLiveMatchs());
            matchesResponse.setResult(BaseResponse.SUCCESS);

            return matchesResponse;
        } catch (Exception e) {
            response = new BaseResponse(BaseResponse.FAIL, e.getMessage());
            return response;
        }
    }
}